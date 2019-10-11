package com.neusoft.bookstore.goods.service;

import com.neusoft.bookstore.base.Response;
import com.neusoft.bookstore.cate.model.GoodsCate;
import com.neusoft.bookstore.goods.model.Goods;

public interface GoodsService {
    //新增商品
    Response saveGoods(Goods goods);
    //判断名字重复
    boolean existGoods(GoodsCate goodsCate);
    //修改商品
    Response updateGoods(Goods goods);
    //根据id查询商品
    Response listGoodsById(Goods goods);
    //sku分类查询商品
    Response listGoodsByPage(Goods goods);
    //修改商品状态
    Response updateGoodsStatus(Goods goods);
    //将商品作废
    Response delGoods(Goods goods);
}
