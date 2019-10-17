package com.neusoft.bookstore.goods.model;

import com.neusoft.bookstore.base.PageReqest;
import com.neusoft.bookstore.file.model.File;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Data
public class Goods extends PageReqest {
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

    private Integer goodsType;

    private List<File> files;

    private Integer flag;
}
