package com.neusoft.bookstore.user.model;

import lombok.Data;

import java.util.List;

@Data
public class Dept {
    private Long id;
    private String deptName;
    private List<User> users;
}
