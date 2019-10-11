package com.neusoft.bookstore.goods.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.neusoft.bookstore.base.Response;
import com.neusoft.bookstore.cate.model.GoodsCate;
import com.neusoft.bookstore.file.mapper.FileMapper;
import com.neusoft.bookstore.file.model.File;
import com.neusoft.bookstore.goods.mapper.GoodsMapper;
import com.neusoft.bookstore.goods.model.Goods;
import com.neusoft.bookstore.goods.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class GoodsServiceImpl implements GoodsService {
    @Autowired
    private GoodsMapper goodsMapper;
    @Autowired
    private FileMapper fileMapper;

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
        List<Goods> goodsList=goodsMapper.listGoodsByPage(goods);
        PageInfo<Goods> goodsPageInfo = new PageInfo<>(goodsList);
        return Response.ok(goodsPageInfo,"查询成功");
    }

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
        if(null != goods.getFiles() && goods.getFiles().size()>0){
//            fileMapper.updateFile(goods);
            //保存新图
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
     * 将商品作废
     * @param goods
     * @return
     */
    @Override
    public Response delGoods(Goods goods) {
        int count = goodsMapper.delGoods(goods);
        if (count <= 0) {
            return Response.error("删除失败");
        }
        return Response.ok("删除成功");
    }
}
