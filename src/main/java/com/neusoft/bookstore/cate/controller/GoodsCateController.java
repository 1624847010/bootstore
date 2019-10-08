package com.neusoft.bookstore.cate.controller;

import com.neusoft.bookstore.base.Response;
import com.neusoft.bookstore.cate.model.GoodsCate;
import com.neusoft.bookstore.cate.service.GoodsCateService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@Api(description = "商品分类管理")
@RequestMapping("goods")
public class GoodsCateController {
    @Autowired
    GoodsCateService goodsCateService;

    @ApiOperation("新增商品分类")
    @PostMapping("/saveGoods")
    public Response saveGoods(@RequestBody GoodsCate goodsCate){
        return goodsCateService.saveGoods(goodsCate);
    }
    /**
     * 查询商品树
     * @return
     */
    @ApiOperation("查询商品分类树")
    @PostMapping("/listGoodsTree")
    public Response listGoodsTree(){
        return goodsCateService.listGoodsTree();
    }
    /**
     * 查询一级类
     * @return
     */
    @ApiOperation("查询商品分类1级菜单")
    @PostMapping("/listOneLevelGoods")
    public Response listOneLevelGoods(){
        return goodsCateService.listOneLevelGoods();
    }
    /**
     * 查询二级类
     * @return
     */
    @ApiOperation("查询商品分类2级菜单")
    @PostMapping("/listTwoLevelGoods")
    public Response listTwoLevelGoods(@RequestBody GoodsCate goodsCate){
        return goodsCateService.listTwoLevelGoods(goodsCate);
    }
}
