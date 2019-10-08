package com.neusoft.bookstore.demo.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface DemoMapper {

    List<Long> listAccount();
}
