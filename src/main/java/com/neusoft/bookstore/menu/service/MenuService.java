package com.neusoft.bookstore.menu.service;

import com.neusoft.bookstore.base.Response;
import com.neusoft.bookstore.menu.model.Menu;

public interface MenuService {
    Response saveMenu(Menu menu);

    Response updateMenu(Menu menu);

    Response deleteMenu(Menu menu);

    Response listMenuTree();
}
