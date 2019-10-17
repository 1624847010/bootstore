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
    @ApiOperation(value = "根据id查询商品")
    @PostMapping("/listGoodsById")
    public Response listGoodsById(@RequestBody Goods goods){
        return goodsService.listGoodsById(goods);
    }
    @ApiOperation(value = "sku分类查询商品")
    @PostMapping("/listGoodsByPage")
    public Response listGoodsByPage(@RequestBody Goods goods){
        return goodsService.listGoodsByPage(goods);
    }
    @ApiOperation(value = "修改商品")
    @PostMapping("/updateGoods")
    public Response updateGoods(@RequestBody Goods goods){
        return goodsService.updateGoods(goods);
    }
    @ApiOperation(value = "修改商品状态")
    @PostMapping("/updateGoodsStatus")
    public Response updateGoodsStatus(@RequestBody Goods goods){
        return goodsService.updateGoodsStatus(goods);
    }
    @ApiOperation(value = "删除商品")
    @PostMapping("/delGoods")
    public Response delGoods(@RequestBody Goods goods){
        return goodsService.delGoods(goods);
    }
}
