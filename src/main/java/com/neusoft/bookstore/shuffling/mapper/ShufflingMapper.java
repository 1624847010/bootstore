package com.neusoft.bookstore.shuffling.mapper;

import com.neusoft.bookstore.shuffling.model.Shuffling;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface ShufflingMapper {
    //插入
    int saveBanner(Shuffling shuffling);
    //分页查询
    List<Shuffling> listShuffling(Shuffling shuffling);
    //删除
    int deleteShuffling(List<Long> list);
    //修改轮播图状态
    int updateShufflingStatus(Shuffling shuffling);
}
