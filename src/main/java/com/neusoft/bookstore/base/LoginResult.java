package com.neusoft.bookstore.base;

import lombok.Data;

@Data
public class LoginResult {

    private Long userId;

    private String userName;

    private String token;
}
