package com.neusoft.bookstore.cate.model;

import lombok.Data;

@Data
public class GoodsCate {
    private Long id;
    private String cateName;
    private Long parentCateId;
    private Integer cateLevel;
    private String remark;
    private String createBy;
    private String lastModifiedBy;
}
