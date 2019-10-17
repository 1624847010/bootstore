package com.neusoft.bookstore.cate.model;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class GoodsTree {
    private Long id;
    private String name;
    private Integer level;
    private Long pid;
    private String remark;

    private List<GoodsTree> child=new ArrayList<>();
}
