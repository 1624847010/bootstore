package com.neusoft.bookstore.sdxl;

import com.github.pagehelper.PageInfo;
import com.neusoft.bookstore.BookStoreApplicationTests;
import com.neusoft.bookstore.sdxl.model.Paging;
import com.neusoft.bookstore.sdxl.model.People;
import com.neusoft.bookstore.sdxl.service.SdxlService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class SdxlTest extends BookStoreApplicationTests {
    @Autowired
    SdxlService sdxlService;

    @Test
    public void saveMany(){
        List<People> peoples=new ArrayList<>();
        People people1=new People();
        people1.setUserName("西门吹雪");
        people1.setUserAcct("ximen");
        people1.setUserPassword("123456");
        people1.setUserEmail("ximen@qq.com");
        peoples.add(people1);
        People people2=new People();
        people2.setUserName("郭靖");
        people2.setUserAcct("guojing");
        people2.setUserPassword("guojing123");
        people2.setUserEmail("guojing@qq.com");
        peoples.add(people2);
        People people3=new People();
        people3.setUserName("黄蓉");
        people3.setUserAcct("huangrong");
        people3.setUserPassword("h23478");
        people3.setUserEmail("huangrong@qq.com");
        peoples.add(people3);
        People people4=new People();
        people4.setUserName("杨过");
        people4.setUserAcct("yangguo");
        people4.setUserPassword("yg234789");
        people4.setUserEmail("yangguo@qq.com");
        peoples.add(people4);
        People people5=new People();
        people5.setUserName("小龙女");
        people5.setUserAcct("xiaolonglv");
        people5.setUserPassword("x1234789");
        people5.setUserEmail("xiaolonglv@qq.com");
        peoples.add(people5);
        sdxlService.saveMany(peoples);
    }

    @Test
    public void deleteMany(){
        List<String> list=new ArrayList<>();
        list.add("小龙女");
        list.add("郭靖");
        sdxlService.deleteMany(list);
    }

    @Test
    public void selectAll(){
        List<String> list=new ArrayList<>();
        list.add("杨过");
        list.add("黄蓉");
        List<People> people=sdxlService.selectAll(list);
        people.forEach(people1 -> {
            System.out.println(people1);
        });
    }

    @Test
    public void listSysUserByPage(){
        Paging paging=new Paging();
        paging.setPageNum(1);
        paging.setPageSize(3);
        Paging paging1= sdxlService.listSysUserByPage(paging);
        System.out.println(paging1.toString());
    }

    @Test
    public void listUserPageInfo(){
        PageInfo<People> peoplePageInfo=sdxlService.listUserPageInfo(1,3);
        peoplePageInfo.getList().forEach(people -> {
            System.out.println(people);
        });
    }
}