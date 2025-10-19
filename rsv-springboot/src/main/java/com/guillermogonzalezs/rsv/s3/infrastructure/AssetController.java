package com.guillermogonzalezs.rsv.s3.infrastructure;

import com.amazonaws.services.s3.model.S3ObjectSummary;
import com.guillermogonzalezs.rsv.s3.application.S3Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/assets")
public class AssetController {

    @Autowired S3Service s3service;


    @GetMapping("")
    public List<S3ObjectSummary> listAll() {
        return s3service.listObjects();
    }


    @GetMapping(value = "/rename", params =  {"oldKey", "newKey"})
    void rename(@RequestParam String oldKey, @RequestParam String newKey) throws Exception {
        s3service.rename(oldKey, newKey);
    }

    @PostMapping("/upload")
    Map<String, String> upload(@RequestParam MultipartFile file, @RequestParam String bucket) {
        String key = s3service.putObject(file, bucket);
        Map<String, String>  result = new HashMap<>();
        result.put("key", key);
        result.put("url", s3service.getObjectUrl(key));
        return result;


    }


    @DeleteMapping(value = "delete-object", params = "key")
    void deleteObject(@RequestParam String key) {
        s3service.deleteObject(key);
    }
}
