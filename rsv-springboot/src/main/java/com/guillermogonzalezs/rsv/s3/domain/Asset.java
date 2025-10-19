package com.guillermogonzalezs.rsv.s3.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Asset {
    private  byte[] content;
    private  String contentType;
}
