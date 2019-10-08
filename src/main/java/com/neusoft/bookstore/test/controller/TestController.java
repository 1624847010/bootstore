package com.neusoft.bookstore.test.controller;

import com.neusoft.bookstore.test.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
@ResponseBody
public class TestController {
    @Autowired
    private TestService testService;

    @RequestMapping("/")
    public String getTest(){
        String src=testService.getTest();
        return src;
    }
}
