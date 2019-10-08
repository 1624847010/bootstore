package com.neusoft.bookstore.user.service.impl;

import com.neusoft.bookstore.user.mapper.UserMapper;
import com.neusoft.bookstore.user.model.Dept;
import com.neusoft.bookstore.user.model.User;
import com.neusoft.bookstore.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper userMapper;

    //增
    @Override
    public void saveUser(User user) {
        userMapper.saveUser(user);
    }

    //改
    @Override
    public void updateUser(User user) {
        userMapper.updateUser(user);
    }

    //删
    @Override
    public void deleteUser(User user) {
        userMapper.deleteUser(user);
    }

    //批增
    @Override
    public void allsaveUser(List<User> users) {
        Map<String,Object> map=new HashMap<>();
        map.put("uuuu",users);
        userMapper.allsaveUser(map);
    }

    //批删
    @Override
    public int deleteUsers(List<Long> list) {
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("tttt",list);
        int count=userMapper.deleteUsers(list);
        return count;
    }

    //按条件查询
    @Override
    public List<User> getUser(User user) {
        return userMapper.getUser(user);
    }

    //批量查询
    @Override
    public List<User> getUsers(List<Long> list) {
        return  userMapper.getUsers(list);
    }

    //多对一
    @Override
    public List<User> listManyToOne() {
        return userMapper.listManyToOne();
    }

    //一对多
    @Override
    public List<Dept> listOneToMany() {
        return userMapper.listOneToMany();
    }
}
