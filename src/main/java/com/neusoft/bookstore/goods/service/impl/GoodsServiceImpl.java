package com.neusoft.bookstore.goods.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.neusoft.bookstore.base.Response;
import com.neusoft.bookstore.cate.model.GoodsCate;
import com.neusoft.bookstore.file.mapper.FileMapper;
import com.neusoft.bookstore.file.model.File;
import com.neusoft.bookstore.file.service.FileService;
import com.neusoft.bookstore.goods.mapper.GoodsMapper;
import com.neusoft.bookstore.goods.model.Goods;
import com.neusoft.bookstore.goods.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class GoodsServiceImpl implements GoodsService {
    private final Integer FLAG=1;

    @Autowired
    private GoodsMapper goodsMapper;
    @Autowired
    private FileMapper fileMapper;
    @Autowired
    private FileService fileService;

    /**
     * 插入商品数据
     * @param goods
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public Response saveGoods(Goods goods) {
        //判断为空
        //判断名字重复
        int resultcount = goodsMapper.existName(goods);
        if (resultcount > 0) {
            return Response.error("商品名称已存在");
        }
        //插入数据
        int count = goodsMapper.saveGoods(goods);
        if (count <= 0) {
            return Response.error("插入失败");
        }
        //插入图片
        if(null != goods.getFiles() && goods.getFiles().size()>0)
        {
            fileMapper.saveFile(goods);
        }
        return Response.ok("插入成功");
    }

    /**
     * 判断分类下是否存在商品
     * @param goodsCate 存在为真，不存在为假
     * @return
     */
    @Override
    public boolean existGoods(GoodsCate goodsCate) {
        int count=goodsMapper.existGoods(goodsCate);
        if (count>0){
            return true;
        }
        return false;
    }

    /**
     * 根据id查询
     * @param id
     * @return
     */
    @Override
    public Response listGoodsById(Goods goods) {
        Long id = goods.getId();
        if (null == id && id.equals("")) {
            return Response.error("没有传入id");
        }
        Goods good = goodsMapper.listGoodsById(id);
        if (null == good) {
            return Response.error("查询失败");
        }
        File file=new File();
        file.setBusinessId(id);
        file.setBusinessType(1);
        List<File> files=fileMapper.listFile(file);
        good.setFiles(files);
        return Response.ok(good,"查询成功");
    }

    /**
     * sku分类查询商品
     * @param goods
     * @return
     */
    @Override
    public Response listGoodsByPage(Goods goods) {
        PageHelper.startPage(goods.getPageNum(),goods.getPageSize());
        List<Goods> goodsList;
        //前端传入flag，若为1则不反回图片
        if (FLAG.intValue() == goods.getFlag().intValue()){
            goodsList = goodsMapper.listGoodsByPage(goods);
        }else {
            goodsList = goodsMapper.listAppGoodsByPage(goods);
        }
        PageInfo<Goods> goodsPageInfo = new PageInfo<>(goodsList);
        return Response.ok(goodsPageInfo,"查询成功");
    }

    /**
     * 修改商品
     * @param goods
     * @return
     */
    @Override
    public Response updateGoods(Goods goods) {
        //判断名字重复
        int resultcount = goodsMapper.existName(goods);
        if (resultcount > 0) {
            return Response.error("商品名称已存在");
        }
        //修改信息
        int upcount = goodsMapper.updateGoods(goods);
        if (upcount <= 0) {
            return Response.error("修改失败");
        }
        //修改图片
        //删除所有图片
        goods.setGoodsType(1);
        fileMapper.delFileByGoods(goods);
        //保存新图
        if (null != goods.getFiles() && goods.getFiles().size()>0) {
            fileMapper.saveFile(goods);
        }
        return Response.ok("修改成功");
    }

    /**
     * 修改商品状态
     * @param goods
     * @return
     */
    @Override
    public Response updateGoodsStatus(Goods goods) {
        int count = goodsMapper.updateGoodsStatus(goods);
        if (count <= 0) {
            return Response.error("修改失败");
        }
        return Response.ok("修改成功");
    }

    /**
     * 将商品删除
     * @param goods
     * @return
     */
    @Override
    public Response delGoods(Goods goods) {
        //id是否为空
        if (null == goods.getId()) {
            return Response.error("id不能为空");
        }
        //删除商品
        int count = goodsMapper.delGoods(goods);
        if (count <= 0) {
            return Response.error("删除失败");
        }
        //查询图片
        File file=new File();
        file.setBusinessId(goods.getId());
        file.setBusinessType(1);
        List<File> files=fileMapper.listFile(file);
        //删除图片
        for (File fl:files) {
            fileService.delFile(fl);
        }
        return Response.ok("删除成功");
    }

    /**
     * 查询商品销售状态
     * @param skuId
     * @return
     */
    @Override
    public int listGoodsStatus(Long skuId) {
        Goods goods = goodsMapper.listGoodsStatus(skuId);
        return goods.getStatus();
    }

    /**
     * 查询商品库存
     * @param skuId
     * @return
     */
    @Override
    public int listGoodsStock(Long skuId) {
        Goods goods = goodsMapper.listGoodsStock(skuId);
        return goods.getStock();
    }
}
