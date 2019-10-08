package com.neusoft.bookstore.menu.mapper;


import com.neusoft.bookstore.base.Response;
import com.neusoft.bookstore.menu.model.Menu;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface MenuMapper {
    //新增菜单
    int saveMenu(Menu menu);
    //验证菜单名称是否存在
    int getMenuNameCount(Menu menu);
    //修改菜单
    int updateMenu(Menu menu);
    //验证是否存在子菜单
    int listChildMenu(Menu menu);
    //删除菜单
    int deleteMenu(Menu menu);
    //查询所有菜单
    List<Menu> listMenu();
}
