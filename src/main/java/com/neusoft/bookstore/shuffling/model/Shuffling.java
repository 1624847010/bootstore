package com.neusoft.bookstore.shuffling.model;

import lombok.Data;

import java.util.List;

@Data
public class Shuffling {
    private Long id;
    private String fileUrl;
    private String filePath;
    private Integer isDeleted;
    private String status;
    private String createBy;
    private Integer pageSize;
    private Integer pageNum;
    private Integer sortNo;
    private List<Long> list;
    private String gmtCreate;
    private String gmtModified;
    private String lastModifiedBy;
    private Integer version;
}
