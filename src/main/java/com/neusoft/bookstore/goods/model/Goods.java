package com.neusoft.bookstore.goods.model;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class Goods {
    private Long id;

    private String skuName;

    private BigDecimal costPrice;

    private BigDecimal salePrice;

    private Integer saleCount;

    private String detail;

    private Date putawayTime;

    private Date lowerTime;

    private Integer status;

    private Long browseCount;

    private String author;

    private String advertising;

    private String isbn;

    private Integer stock;

    private Integer isDeleted;

    private Integer sortNo;

    private Date gmtCreate;

    private String createBy;

    private Date gmtModified;

    private String lastModifiedBy;

    private Integer version;

    private Long oneCateId;

    private Long twoCateId;
}
