package com.neusoft.bookstore.sdxl.model;

import lombok.Data;


@Data
public class People {
    private Long id;
    //名称
    private String userName;
    //账号
    private String userAcct;
    //密码
    private String userPassword;
    //邮箱
    private String userEmail;
    //创建时间
    private String userAt;
}
