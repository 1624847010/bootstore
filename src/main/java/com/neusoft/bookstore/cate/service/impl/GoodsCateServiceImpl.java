package com.neusoft.bookstore.cate.service.impl;

import com.neusoft.bookstore.base.Response;
import com.neusoft.bookstore.cate.mapper.GoodsCateMapper;
import com.neusoft.bookstore.cate.model.GoodsCate;
import com.neusoft.bookstore.cate.model.GoodsTree;
import com.neusoft.bookstore.cate.service.GoodsCateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Iterator;
import java.util.List;

@Service
public class GoodsCateServiceImpl implements GoodsCateService {
    @Autowired
    GoodsCateMapper goodsCateMapper;

    /**
     * 新增商品分类
     * @param goodsCate
     * @return
     */
    @Override
    public Response saveGoods(GoodsCate goodsCate) {
        if (null == goodsCate.getCateName())
            return Response.error("请输入分类名称");
        //验证名称是否重复
        int nameAccount= goodsCateMapper.getGoodsNameCount(goodsCate);
        if (nameAccount >0) {
            return Response.error("用户名重复");
        }
        int goodsCount = goodsCateMapper.saveGoods(goodsCate);
        if (goodsCount <=0) {
            return Response.error("新增失败");
        }
        return Response.ok("新增成功");
    }
    /**
     * 查询商品树
     * @return
     */
    @Override
    public Response listGoodsTree() {
        //查询所有商品
        List<GoodsCate> listGoods= goodsCateMapper.listGoods();
        //定义商品分类树
        GoodsTree goodsTree=new GoodsTree();
        this.recursionGoodsTree(listGoods,goodsTree,0L);
        return Response.ok(goodsTree.getChild(),"查询成功");
    }


    private void recursionGoodsTree(List<GoodsCate> goodsCateList, GoodsTree goodsTree, Long selfId){
        //迭代器取出对象
        Iterator<GoodsCate> goodsIterator= goodsCateList.iterator();
        while (goodsIterator.hasNext()){
            GoodsCate goodsCate = goodsIterator.next();
            if (goodsCate.getId().equals(selfId)){
                this.setGoods(goodsTree, goodsCate);
            }
            if (goodsCate.getParentCateId().equals(selfId)){
                GoodsTree newGoodsTree=new GoodsTree();
                this.setGoods(newGoodsTree, goodsCate);
                goodsTree.getChild().add(newGoodsTree);
                this.recursionGoodsTree(goodsCateList,newGoodsTree, goodsCate.getId());
            }
        }
    }

    private void setGoods(GoodsTree goodsTree, GoodsCate goodsCate) {
        goodsTree.setId(goodsCate.getId());
        goodsTree.setLevel(goodsCate.getCateLevel());
        goodsTree.setName(goodsCate.getCateName());
        goodsTree.setPid(goodsCate.getParentCateId());
    }

    /**
     * 查询一级目录
     * @return
     */
    @Override
    public Response listOneLevelGoods() {
        List<GoodsCate> list= goodsCateMapper.listOneLevelGoods();
        return Response.ok(list,"查询成功");
    }

    /**
     * 查询一级目录下的二级目录
     * @param goodsCate
     * @return
     */
    @Override
    public Response listTwoLevelGoods(GoodsCate goodsCate) {
        List<GoodsCate> list= goodsCateMapper.listTwoLevelGoods(goodsCate.getId());
        return Response.ok(list,"查询成功");
    }
}
