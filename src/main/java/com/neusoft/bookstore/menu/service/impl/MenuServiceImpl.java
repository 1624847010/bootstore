package com.neusoft.bookstore.menu.service.impl;

import com.neusoft.bookstore.base.Response;
import com.neusoft.bookstore.menu.mapper.MenuMapper;
import com.neusoft.bookstore.menu.model.Menu;
import com.neusoft.bookstore.menu.model.MenuTree;
import com.neusoft.bookstore.menu.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Iterator;
import java.util.List;

@Service
public class MenuServiceImpl implements MenuService {
    private final Long ROOT_PARENT_ID=0L;
    @Autowired
    MenuMapper menuMapper;

    /**
     * 新增菜单
     * @param menu
     * @return
     */
    @Override
    public Response saveMenu(Menu menu) {
        //判断菜单名称不能为空
        if (null == menu.getMenuName()) {
            return Response.error("菜单名称不能为空");
        }
        //判断菜单层次不能为空
        if (null == menu.getMenuLevel()) {
            return Response.error("菜单层次不能为空");
        }
        //菜单类型不能为空
        if (null == menu.getMenuType()) {
            return Response.error("菜单类型不能为空");
        }
        //验证菜单名称是否存在
        int nameCount=menuMapper.getMenuNameCount(menu);
        if (nameCount >0) {
            return Response.error("菜单名称已存在");
        }
        //如果是顶级菜单，默认父级菜单id为0
        if (null == menu.getParentId()) {
            menu.setParentId(ROOT_PARENT_ID);
        }
        int i = menuMapper.saveMenu(menu);
        if (i <=0) {
            return Response.error("新增失败");
        }
        return Response.ok("新增成功");
    }
    /**
     * 修改菜单
     * @param menu
     * @return
     */
    @Override
    public Response updateMenu(Menu menu) {
        //判断菜单名称不能为空
        if (null == menu.getMenuName()) {
            return Response.error("菜单名称不能为空");
        }
        //验证菜单名称是否存在
        int nameCount=menuMapper.getMenuNameCount(menu);
        if (nameCount >0) {
            return Response.error("菜单名称已存在");
        }
        int i = menuMapper.updateMenu(menu);
        if (i <=0) {
            return Response.error("修改失败");
        }
        return Response.ok("修改成功");
    }
    /**
     * 删除菜单
     * @param menu
     * @return
     */
    @Override
    public Response deleteMenu(Menu menu) {
        //判断是否有id
        if (null == menu.getId()) {
            return Response.error("id不能为空");
        }
        int menuCount=menuMapper.listChildMenu(menu);
        if (menuCount >0) {
            return Response.error("当前菜单存在子菜单，无法删除");
        }
        //删除菜单
        int deleteCount = menuMapper.deleteMenu(menu);
        if (deleteCount <= 0) {
            return Response.error("删除失败");
        }
        return Response.ok("删除成功");
    }
    /**
     * 查询菜单树
     * @return
     */
    @Override
    public Response listMenuTree() {
        //查询所有菜单
        List<Menu> menuList = menuMapper.listMenu();
        //定义菜单树
        MenuTree menuTree=new MenuTree();
        this.recursionMenuTree(menuList,menuTree,0L);
        return Response.ok(menuTree.getChild(),"查询成功");
    }
    /**
     * 递归初始化菜单树
     * @param menuList
     * @param menuTree
     * @param selfId
     */private void recursionMenuTree(List<Menu> menuList,MenuTree menuTree,Long selfId){
        //迭代取出菜单对象
        Iterator<Menu> iterable=menuList.iterator();
        //循环取出菜单对象
        while (iterable.hasNext()){
            //取集合的数据
            Menu menu = iterable.next();
            //初始化自身菜单
            if (menu.getId().equals(selfId)){
                //给菜单树menuTree赋值
                this.setMenuTree(menuTree, menu);
            }
            //初始化子菜单
            if (menu.getParentId().equals(selfId)){
                //定义新的树对象
                MenuTree newMenuTree =new MenuTree();
                //给菜单树newMenuTree赋值
                this.setMenuTree(newMenuTree,menu);
                //将子菜单添加到父级菜单上
                menuTree.getChild().add(newMenuTree);
                //递归菜单
                this.recursionMenuTree(menuList,newMenuTree,menu.getId());
            }
        }
    }
    /**
     * 赋值子菜单
     * @param menuTree
     * @param menu
     */
    private void setMenuTree(MenuTree menuTree, Menu menu) {
        //菜单id
        menuTree.setId(menu.getId());
        //菜单名称
        menuTree.setName(menu.getMenuName());
        //菜单url
        menuTree.setUrl(menu.getMenuUrl());
        //菜单层级
        menuTree.setLevel(menu.getMenuLevel());
        //菜单类型
        menuTree.setType(menu.getMenuType());
        //菜单对象
        menuTree.setMenu(menu);
        //菜单父级
        menuTree.setPid(menu.getParentId());
    }
}