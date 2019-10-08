package com.neusoft.bookstore.user.service;

import com.neusoft.bookstore.user.model.Dept;
import com.neusoft.bookstore.user.model.User;

import java.util.List;

public interface UserService {
    //保存用户
    void saveUser(User user);
    //修改用户名
    void updateUser(User user);
    //删除用户
    void deleteUser(User user);
    //批量新增
    void allsaveUser(List<User> users);
    //批删
    int deleteUsers(List<Long> list);
    //条件查询
    List<User> getUser(User user);
    //批量查询
    List<User> getUsers(List<Long> list);
    //查询（多对一）
    List<User> listManyToOne();
    //一对多
    List<Dept> listOneToMany();
}
