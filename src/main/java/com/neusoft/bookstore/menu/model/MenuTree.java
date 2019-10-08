package com.neusoft.bookstore.menu.model;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class MenuTree {
    private Long id;
    private String name;
    private String url;
    private Integer level;
    private Integer type;
    private Long pid;
    private Menu menu;
    private List<MenuTree> child = new ArrayList<>();
}
