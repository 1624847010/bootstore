package com.neusoft.bookstore.user.model;

import lombok.Data;

@Data
public class User {
    //id
    private Long id;
    //用户名
    private String username;
    //部门对象
    private Dept dept;
}
