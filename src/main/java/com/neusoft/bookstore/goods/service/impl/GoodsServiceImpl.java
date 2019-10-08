package com.neusoft.bookstore.goods.service.impl;

import com.neusoft.bookstore.base.Response;
import com.neusoft.bookstore.cate.model.GoodsCate;
import com.neusoft.bookstore.goods.mapper.GoodsMapper;
import com.neusoft.bookstore.goods.model.Goods;
import com.neusoft.bookstore.goods.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GoodsServiceImpl implements GoodsService {
    @Autowired
    private GoodsMapper goodsMapper;

    @Override
    public Response saveGoods(Goods goods) {
        //判断为空
        //插入图片
        //判断名字重复
        int resultcount = goodsMapper.existName(goods);
        if (resultcount <= 0) {
            return Response.error("商品名称已存在");
        }
        //插入数据
        int count = goodsMapper.saveGoods(goods);
        if (count <= 0) {
            return Response.error("插入失败");
        }
        return Response.ok("插入成功");
    }

    @Override
    public boolean existGoods(GoodsCate goodsCate) {
        int count=goodsMapper.existGoods(goodsCate);
        if (count>0){
            return true;
        }
        return false;
    }
}
