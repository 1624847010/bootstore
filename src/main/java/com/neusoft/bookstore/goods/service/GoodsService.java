package com.neusoft.bookstore.goods.service;

import com.neusoft.bookstore.base.Response;
import com.neusoft.bookstore.cate.model.GoodsCate;
import com.neusoft.bookstore.goods.model.Goods;

public interface GoodsService {
    Response saveGoods(Goods goods);

    boolean existGoods(GoodsCate goodsCate);
}
