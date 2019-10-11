package com.neusoft.bookstore.base;

import lombok.Data;

@Data
public class PageReqest {

    private Integer pageNum;

    private Integer pageSize;
}
