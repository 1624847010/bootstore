package com.neusoft.bookstore.sdxl.service;

import com.github.pagehelper.PageInfo;
import com.neusoft.bookstore.sdxl.model.Paging;
import com.neusoft.bookstore.sdxl.model.People;

import java.util.List;

public interface SdxlService {
    //批量新增
    void saveMany(List<People> people);

    //批量删除
    void deleteMany(List<String> list);

    //查询杨过和黄蓉的用户信息并按照创建时间倒叙排列
    List<People> selectAll(List<String> list);

    //分页查询
    Paging listSysUserByPage(Paging paging);

    //插件分页
    PageInfo<People> listUserPageInfo(int pageNum, int pageSize);
}