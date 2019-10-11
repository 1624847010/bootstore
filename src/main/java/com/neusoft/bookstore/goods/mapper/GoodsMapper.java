package com.neusoft.bookstore.goods.mapper;

import com.neusoft.bookstore.base.Response;
import com.neusoft.bookstore.cate.model.GoodsCate;
import com.neusoft.bookstore.goods.model.Goods;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface GoodsMapper {
    int saveGoods(Goods goods);

    int existGoods(GoodsCate goodsCate);

    int existName(Goods goods);

    Goods listGoodsById(Long id);

    int updateGoods(Goods goods);

    List<Goods> listGoodsByPage(Goods goods);

    int updateGoodsStatus(Goods goods);

    int delGoods(Goods goods);
}
