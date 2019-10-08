package com.neusoft.bookstore.sdxl.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.neusoft.bookstore.sdxl.mapper.SdxlMapper;
import com.neusoft.bookstore.sdxl.model.Paging;
import com.neusoft.bookstore.sdxl.model.People;
import com.neusoft.bookstore.sdxl.service.SdxlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SdxlServiceImpl implements SdxlService {
    @Autowired
    SdxlMapper sdxlMapper;
    @Override
    public void saveMany(List<People> people) {
        sdxlMapper.saveMany(people);
    }

    @Override
    public void deleteMany(List<String> list) {
        sdxlMapper.deleteMany(list);
    }

    @Override
    public List<People> selectAll(List<String> list) {
        return sdxlMapper.selectAll(list);
    }

    @Override
    public Paging listSysUserByPage(Paging paging) {
        if (null != paging.getPageNum() && null != paging.getPageSize()){
            //总条数
            int count=sdxlMapper.listUserCount();
            paging.setTotalCount(count);
            //总页数
            int totalPage=count % paging.getPageSize() == 0 ? count / paging.getPageSize():count / paging.getPageSize()+1;
            paging.setTotalPage(totalPage);
            //初始页
            int startData=(paging.getPageNum()-1) * paging.getPageSize();
            paging.setStarData(startData);
            List<People> list=sdxlMapper.listSysUserByPage(startData,paging.getPageSize());
            paging.setDataList(list);
            return paging;
        }
        return null;
    }

    /**
     *
     * @param pageNum 当前页数
     * @param pageSize 每页多少条
     */
    public PageInfo<People> listUserPageInfo(int pageNum,int pageSize){
        PageHelper.startPage(pageNum,pageSize);
        List<People> userList=sdxlMapper.listUserPageInfo();
        return new PageInfo<People>(userList);
    }
}
