package com.neusoft.bookstore.test.service.impl;

import com.neusoft.bookstore.test.mapper.TestMapper;
import com.neusoft.bookstore.test.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TestServiceImpl implements TestService {
    @Autowired
    private TestMapper testMapper;

    @Override
    public String getTest() {
        String str=testMapper.getTest();
        return str;
    }
}
