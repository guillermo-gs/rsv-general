package com.guillermogonzalezs.rsv.s3.application;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.*;
import com.amazonaws.util.IOUtils;
import com.guillermogonzalezs.rsv.s3.domain.Asset;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.model.GetObjectRequest;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@Service
public class S3Service {
    private static final String BUCKET = "rsvfacturas-bucket";

    @Autowired
    private AmazonS3Client s3Client;

    private S3Client _s3;
//    private AmazonS3Client s3Client;


    public List<S3ObjectSummary> listObjects() {
        ListObjectsV2Result result = s3Client.listObjectsV2(BUCKET);
        return  result.getObjectSummaries();
    }


    public void rename(String oldKey, String newKey) throws Exception {
        try {
            s3Client.copyObject(BUCKET, oldKey, BUCKET, newKey);
            this.deleteObject(oldKey);
        } catch (AmazonServiceException e) {
            throw new Exception(e.getMessage());
        }
    }


    public String putObject(MultipartFile multipartFile, String bucket) {
        String extension = StringUtils.getFilenameExtension(multipartFile.getOriginalFilename());
        String key = multipartFile.getOriginalFilename();

        ObjectMetadata objectMetadata = new ObjectMetadata();
        objectMetadata.setContentType(multipartFile.getContentType());

        try {
            PutObjectRequest putObjectRequest = new PutObjectRequest(bucket, key, multipartFile.getInputStream(), objectMetadata);
            s3Client.putObject(putObjectRequest);
            return key;
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }

    public Asset getObject(String bucket, String key) {
        S3Object s3Object = s3Client.getObject(bucket , key);
        ObjectMetadata metadata = s3Object.getObjectMetadata();
        try {
            S3ObjectInputStream inputStream = s3Object.getObjectContent();
            byte[] bytes = IOUtils.toByteArray(inputStream);
            return new Asset(bytes, metadata.getContentType());
        } catch (IOException ex) {
            throw  new RuntimeException(ex);
        }
    }

    public void deleteObject(String key) {
        s3Client.deleteObject(BUCKET, key);
    }

    public String getObjectUrl(String key) {
        return  String.format("https://%s.amazonaws.com/%s", BUCKET, key);
    }

    public InputStream downloadFile(String key) {
        GetObjectRequest getObjectRequest = GetObjectRequest.builder()
                .bucket(BUCKET)
                .key(key)
                .build();

         return _s3.getObject(getObjectRequest);
    }

}
