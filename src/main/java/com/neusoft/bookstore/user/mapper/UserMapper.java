package com.neusoft.bookstore.user.mapper;

import com.neusoft.bookstore.user.model.Dept;
import com.neusoft.bookstore.user.model.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Mapper
@Repository
public interface UserMapper {
    void saveUser(User user);

    void updateUser(User user);

    void deleteUser(User user);

    void allsaveUser(Map<String, Object> users);

    int deleteUsers(List<Long> list);

    List<User> getUser(User user);


    List<User> getUsers(List<Long> list);

    List<User> listManyToOne();

    List<Dept> listOneToMany();
}
