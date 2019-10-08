package com.neusoft.bookstore.test.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;


@Repository
@Mapper
public interface TestMapper {
    String getTest();
}
