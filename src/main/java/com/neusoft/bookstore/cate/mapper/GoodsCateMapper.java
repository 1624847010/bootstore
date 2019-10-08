package com.neusoft.bookstore.cate.mapper;

import com.neusoft.bookstore.cate.model.GoodsCate;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface GoodsCateMapper {
    List<GoodsCate> listAllGoods();

    int saveGoods(GoodsCate goodsCate);

    int getGoodsNameCount(GoodsCate goodsCate);

    List<GoodsCate> listOneLevelGoods();

    List<GoodsCate> listTwoLevelGoods(Long id);

    GoodsCate listGoods(GoodsCate goodsCate);

    void updateMyGoods(GoodsCate goodsCate);

    void deleteMyGoods(GoodsCate goodsCate);
}
