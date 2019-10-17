package com.neusoft.bookstore.shop.model;

import lombok.Data;

@Data
public class Shop {
    private String token;
    private Long id;
    private Long skuId;
    private Integer count;
    private Integer isDeleted;
    private Integer sortNo;
    private String gmtCreate;
    private String createBy;
    private String gmtModified;
    private String lastModifiedBy;
    private String version;
}
