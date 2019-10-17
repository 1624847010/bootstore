package com.neusoft.bookstore.shuffling.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.neusoft.bookstore.base.Response;
import com.neusoft.bookstore.shuffling.mapper.ShufflingMapper;
import com.neusoft.bookstore.shuffling.model.Shuffling;
import com.neusoft.bookstore.shuffling.service.ShufflingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShufflingServiceImpl implements ShufflingService {
    @Autowired
    private ShufflingMapper shufflingMapper;

    /**
     * 新增轮播图
     * @param shuffling
     * @return
     */
    @Override
    public Response saveBanner(Shuffling shuffling) {
        int count = shufflingMapper.saveBanner(shuffling);
        if (0 >= count) {
            return Response.error("参数请求错误");
        }
        return Response.ok("新增成功");
    }

    /**
     * 分页查询轮播图
     * @param shuffling
     * @return
     */
    @Override
    public Response listShufflingByPage(Shuffling shuffling) {
        if (null == shuffling.getPageNum() || null == shuffling.getPageSize()) {
            return Response.error("参数传递错误");
        }
        PageHelper.startPage(shuffling.getPageNum(),shuffling.getPageSize());
        List<Shuffling> list=shufflingMapper.listShuffling(shuffling);
        PageInfo<Shuffling> pageInfo = new PageInfo<>(list);
        return Response.ok(pageInfo,"查询成功");
    }

    /**
     * 删除轮播图
     * @param list
     * @return
     */
    @Override
    public Response deleteShuffling(List<Long> list) {
        int count = shufflingMapper.deleteShuffling(list);
        if (0 >= count) {
            return Response.error("删除失败");
        }
        return Response.ok("删除成功");
    }

    /**
     * 修改轮播图状态
     * @param shuffling
     * @return
     */
    @Override
    public Response updateShufflingStatus(Shuffling shuffling) {
        int count = shufflingMapper.updateShufflingStatus(shuffling);
        if (0 >= count) {
            return Response.error("参数请求错误");
        }
        return Response.ok("修改成功");
    }
}
