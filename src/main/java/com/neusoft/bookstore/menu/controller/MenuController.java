package com.neusoft.bookstore.menu.controller;

import com.neusoft.bookstore.base.Response;
import com.neusoft.bookstore.menu.model.Menu;
import com.neusoft.bookstore.menu.service.MenuService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//@RestController 为@responsebody与@Controller的合体
@Api(description = "菜单相关controller")
@RestController
@RequestMapping("/menu")
public class MenuController {
    @Autowired
    MenuService menuService;

    @ApiOperation(value = "新增菜单")
    @PostMapping("/saveMenu")
    public Response saveMenu(@RequestBody Menu menu){
        return menuService.saveMenu(menu);
    }
    @ApiOperation(value = "修改菜单")
    @PostMapping("/updateMenu")
    public Response updateMenu(@RequestBody Menu menu){
        return menuService.updateMenu(menu);
    }
    @ApiOperation(value = "删除菜单")
    @PostMapping("/deleteMenu")
    public Response deleteMenu(@RequestBody Menu menu){
        return menuService.deleteMenu(menu);
    }
    /**
     * 查询菜单树
     * @param menu
     * @return
     */
    @ApiOperation(value = "查询菜单树")
    @PostMapping("/listMenuTree")
    public Response listMenuTree(){
        return menuService.listMenuTree();
    }
}
