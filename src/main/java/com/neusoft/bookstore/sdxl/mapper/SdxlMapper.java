package com.neusoft.bookstore.sdxl.mapper;

import com.neusoft.bookstore.sdxl.model.Paging;
import com.neusoft.bookstore.sdxl.model.People;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface SdxlMapper {
    void saveMany(List<People> people);

    void deleteMany(List<String> list);

    List<People> selectAll(List<String> list);

    int listUserCount();

    List<People> listSysUserByPage(@Param("starData")Integer starData,@Param("pageSize")Integer pageSize);

    List<People> listUserPageInfo();
}
