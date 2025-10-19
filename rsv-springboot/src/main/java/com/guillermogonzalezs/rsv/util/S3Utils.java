package com.guillermogonzalezs.rsv.util;

import org.springframework.web.multipart.MultipartFile;

import java.nio.charset.Charset;
import java.text.Normalizer;
import java.util.Random;
import java.util.regex.Pattern;

public class S3Utils {
    public static String normalizeFileName(String fileName, String originalFilename) {
        // Convertir a minúsculas
        fileName = fileName.toLowerCase();

        // Eliminar acentos y caracteres especiales
        fileName = Normalizer.normalize(fileName, Normalizer.Form.NFD);
        Pattern pattern = Pattern.compile("\\p{InCombiningDiacriticalMarks}+");
        fileName = pattern.matcher(fileName).replaceAll("");

        // Reemplazar caracteres no deseados con guion bajo
        fileName = fileName.replaceAll("[^a-z0-9\\.\\-]", "_");

        // Limitar la longitud del nombre (ejemplo 255 caracteres)
        int maxLength = 255;
        if (fileName.length() > maxLength) {
            fileName = fileName.substring(0, maxLength);
        }

        String extension = S3Utils.getFileExtension(originalFilename);
        if (extension != "") {
            fileName += "." + extension;
        }

        return fileName;
    }

    public static String normalizeFileName(String fileName) {
        // Convertir a minúsculas
        fileName = fileName.toLowerCase();

        // Eliminar acentos y caracteres especiales
        fileName = Normalizer.normalize(fileName, Normalizer.Form.NFD);
        Pattern pattern = Pattern.compile("\\p{InCombiningDiacriticalMarks}+");
        fileName = pattern.matcher(fileName).replaceAll("");

        // Reemplazar caracteres no deseados con guion bajo
        fileName = fileName.replaceAll("[^a-z0-9\\.\\-]", "_");


        // Limitar la longitud del nombre (ejemplo 255 caracteres)
        int maxLength = 255;
        if (fileName.length() > maxLength) {
            fileName = fileName.substring(0, maxLength);
        }

        //TODO quitar que el pdf este hardoceado. Hay que taerlo del ¡fichero
        return fileName + ".pdf";
    }



    public static String getFileExtension(String fileName) {
        if (fileName != null && fileName.lastIndexOf(".") != -1 && fileName.lastIndexOf(".") != 0) {
            return fileName.substring(fileName.lastIndexOf(".") + 1);
        } else {
            return "";
        }
    }


    public static String randomString(Integer num) {
        String palabra = "";
        for (int i=0; i<num; i++){
            int codigoAscii = (int)Math.floor(Math.random()*(122 -   97)+97);
            palabra = palabra + (char)codigoAscii;
        }
        return palabra;
    }

}
