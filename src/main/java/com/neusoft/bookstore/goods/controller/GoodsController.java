package com.neusoft.bookstore.goods.controller;

import com.neusoft.bookstore.base.Response;
import com.neusoft.bookstore.goods.model.Goods;
import com.neusoft.bookstore.goods.service.GoodsService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@Api(description = "商品管理")
@RequestMapping("/goods")
public class GoodsController {
    @Autowired
    private GoodsService goodsService;

    @ApiOperation(value = "新增商品")
    @PostMapping("/saveGoods")
    public Response saveGoods(@RequestBody Goods goods){
        return goodsService.saveGoods(goods);
    }

}
