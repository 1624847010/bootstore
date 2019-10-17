package com.neusoft.bookstore.shop.service;

import com.neusoft.bookstore.base.Response;
import com.neusoft.bookstore.shop.model.Shop;

public interface ShopService {
    /**
     * 添加购物车
     * @param shop
     * @return
     */
    Response saveShop(Shop shop);
}
