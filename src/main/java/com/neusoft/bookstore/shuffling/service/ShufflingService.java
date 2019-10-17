package com.neusoft.bookstore.shuffling.service;


import com.neusoft.bookstore.base.Response;
import com.neusoft.bookstore.shuffling.model.Shuffling;

import java.util.List;

public interface ShufflingService {
    /**
     * 新增轮播图
     * @param shuffling
     * @return
     */
    Response saveBanner(Shuffling shuffling);

    /**
     * 分页查询轮播图
     * @param shuffling
     * @return
     */
    Response listShufflingByPage(Shuffling shuffling);

    /**
     * 删除轮播图
     * @param list
     * @return
     */
    Response deleteShuffling(List<Long> list);

    /**
     * 修改轮播图状态
     * @param shuffling
     * @return
     */
    Response updateShufflingStatus(Shuffling shuffling);
}
