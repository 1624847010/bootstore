package com.neusoft.bookstore.cate.mapper;

import com.neusoft.bookstore.cate.model.GoodsCate;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface GoodsCateMapper {
    List<GoodsCate> listGoods();

    int saveGoods(GoodsCate goodsCate);

    int getGoodsNameCount(GoodsCate goodsCate);

    List<GoodsCate> listOneLevelGoods();

    List<GoodsCate> listTwoLevelGoods(Long id);
}
