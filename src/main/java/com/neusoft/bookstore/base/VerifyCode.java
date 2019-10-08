package com.neusoft.bookstore.base;

import lombok.Data;

import java.util.Date;

@Data
public class VerifyCode {
    private String phoneNum;
    private Date sendDate;
    private long verifyCode;
}
