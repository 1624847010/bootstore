package com.neusoft.bookstore.goods.mapper;

import com.neusoft.bookstore.base.Response;
import com.neusoft.bookstore.cate.model.GoodsCate;
import com.neusoft.bookstore.goods.model.Goods;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface GoodsMapper {
    int saveGoods(Goods goods);

    int existGoods(GoodsCate goodsCate);

    int existName(Goods goods);
}
