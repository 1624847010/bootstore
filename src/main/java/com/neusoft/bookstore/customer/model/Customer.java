package com.neusoft.bookstore.customer.model;

import lombok.Data;

@Data
public class Customer {
    private Long id;
    private String userName;
    private String userAcct;
    private String userPwd;
    private Integer adminFlag;
    private String idCard;
    private Integer sex;
    private String phone;
    private String email;
    private String remark;
    private Integer score;
    private Integer clientId;
    private Integer Deleted;
    private Integer sortNo;
    private String gmtCreate;
    private String createBy;
    private String gmtModified;
    private String lastModifiedBy;
    private Integer version;

    //验证码
    private Long code;

    //当前页
    private Integer PageNum;
    //每页展示的最大数目
    private Integer PageSize;
}