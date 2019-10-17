package com.neusoft.bookstore.shop.service.impl;

import com.neusoft.bookstore.base.Response;
import com.neusoft.bookstore.goods.service.GoodsService;
import com.neusoft.bookstore.shop.mapper.ShopMapper;
import com.neusoft.bookstore.shop.model.Shop;
import com.neusoft.bookstore.shop.service.ShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ShopServiceImpl implements ShopService {
    private final Integer FLAG = 2;
    @Autowired
    private ShopMapper shopMapper;
    @Autowired
    private GoodsService goodsService;

    /**
     * 添加购物车
     * @param shop
     * @return
     */
    @Override
    public Response saveShop(Shop shop) {
        //商品是否上架
        int status = goodsService.listGoodsStatus(shop.getSkuId());
        if (FLAG.intValue() != status) {
            return Response.error("商品未在上架");
        }
        //商品库存是否大于购买数量
        int stock = goodsService.listGoodsStock(shop.getSkuId());
        if (shop.getCount().intValue() > stock) {
            return Response.error("商品库存不足");
        }
        //保存
        int count = shopMapper.saveShop(shop);
        if (0 >= count) {
            return Response.error("添加失败");
        }
        return Response.ok("添加成功");
    }
}
