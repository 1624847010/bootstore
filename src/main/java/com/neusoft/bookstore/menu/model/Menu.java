package com.neusoft.bookstore.menu.model;

import lombok.Data;

@Data
public class Menu {
    private Long id;
    private String menuName;
    private String MenuUrl;
    private Long parentId;
    private Integer menuType;
    private Integer menuLevel;
    private String remark;
    private String createBy;
    private String lastModifiedBy;
}
