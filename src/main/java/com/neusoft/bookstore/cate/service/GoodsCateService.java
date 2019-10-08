package com.neusoft.bookstore.cate.service;

import com.neusoft.bookstore.base.Response;
import com.neusoft.bookstore.cate.model.GoodsCate;

public interface GoodsCateService {
    //查询商品分类树
    Response listGoodsTree();
    //新增商品分类
    Response saveGoods(GoodsCate goodsCate);

    Response listOneLevelGoods();

    Response listTwoLevelGoods(GoodsCate goodsCate);

    Response listGoods(GoodsCate goodsCate);

    Response updateGoods(GoodsCate goodsCate);

    Response deleteGoods(GoodsCate goodsCate);
}
