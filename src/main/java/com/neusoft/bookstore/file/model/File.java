package com.neusoft.bookstore.file.model;

import lombok.Data;

@Data
public class File {
    private Long id;

    private String fileName;

    private String fileUrl;

    private String filePath;

    private Long businessId;

    private Integer businessType;
}