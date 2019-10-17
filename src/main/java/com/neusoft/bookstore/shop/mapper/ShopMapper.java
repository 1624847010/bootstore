package com.neusoft.bookstore.shop.mapper;

import com.neusoft.bookstore.shop.model.Shop;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface ShopMapper {
    int saveShop(Shop shop);
}
