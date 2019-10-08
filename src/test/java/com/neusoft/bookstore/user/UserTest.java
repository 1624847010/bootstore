package com.neusoft.bookstore.user;

import com.neusoft.bookstore.BookStoreApplicationTests;
import com.neusoft.bookstore.user.model.Dept;
import com.neusoft.bookstore.user.model.User;
import com.neusoft.bookstore.user.service.impl.UserServiceImpl;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class UserTest extends BookStoreApplicationTests {
    @Autowired
    UserServiceImpl userService;

    //增
    @Test
    public void saveUserTest(){
        User user=new User();
        user.setUsername("王五");
        userService.saveUser(user);
    }

    //改
    @Test
    public void updateUserTest(){
        User user=new User();
        user.setId(1002L);
        user.setUsername("王八");
        userService.updateUser(user);
    }

    //删
    @Test
    public void deleteUserTest(){
        User user=new User();
        user.setId(1002L);
        userService.deleteUser(user);
    }
    //批增
    @Test
    public void allsaveUserTest(){
        List<User> users=new ArrayList<>();
        User user1=new User();
        user1.setUsername("蒋鑫鑫");
        User user2=new User();
        user2.setUsername("尹政");
        users.add(user1);
        users.add(user2);
        userService.allsaveUser(users);
    }
    //批删
    @Test
    public void deleteUsers(){
        List<Long> list=new  ArrayList<>();
        list.add(1010L);
        list.add(1011L);
        userService.deleteUsers(list);
    }

    //查一个叫蒋鑫鑫的人
    @Test
    public void getUser(){
        User user=new User();
        user.setUsername("蒋鑫鑫");
        List<User> users=userService.getUser(user);
        users.forEach(user1 -> {
            System.out.println(user1);
        });
    }

    //按id批量查询
    @Test
    public void getUsers(){
        List<Long> list=new ArrayList<>();
        list.add(1012L);
        list.add(1013L);
        List<User> users=userService.getUsers(list);
        users.forEach(user -> {
            System.out.println(user);
        });
    }

    //多对一
    @Test
    public void listManyToOne(){
       List<User> users=userService.listManyToOne();
       users.forEach(user -> {
           System.out.println(user);
       });
    }

    //一对多
    @Test
    public void listOneToMany(){
        List<Dept> users=userService.listOneToMany();
        users.forEach(user ->{
            System.out.println(user);
        });
    }
}
