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
    //插入商品
    int saveGoods(Goods goods);
    //判断分类下存在文件
    int existGoods(GoodsCate goodsCate);
    //判断名称重复
    int existName(Goods goods);
    //根据id查询商品
    Goods listGoodsById(Long id);
    //修改商品信息
    int updateGoods(Goods goods);
    //分页查询
    List<Goods> listGoodsByPage(Goods goods);
    //修改商品状态
    int updateGoodsStatus(Goods goods);
    //删除商品
    int delGoods(Goods goods);
    //查询app端商品
    List<Goods> listAppGoodsByPage(Goods goods);
    //查询在售状态
    Goods listGoodsStatus(Long skuId);
    //查询库存
    Goods listGoodsStock(Long skuId);
}
