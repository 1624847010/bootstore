package com.neusoft.bookstore.sdxl.model;

import lombok.Data;

import java.util.List;

@Data
public class Paging {
    //当前页码
    private Integer pageNum;
    //每页大小
    private Integer pageSize;
    //总共条数
    private Integer totalCount;
    //总页数
    private Integer totalPage;
    //每一页的数据
    private List<?> dataList;
    //起始页
    private int starData;
}
