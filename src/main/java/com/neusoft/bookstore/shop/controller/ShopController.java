package com.neusoft.bookstore.shop.controller;

import com.neusoft.bookstore.base.LoginResult;
import com.neusoft.bookstore.base.Response;
import com.neusoft.bookstore.shop.model.Shop;
import com.neusoft.bookstore.shop.service.ShopService;
import com.neusoft.bookstore.utils.SessionUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@Api(description = "购物车")
@RestController
@RequestMapping("shop")
public class ShopController {
    @Autowired
    private ShopService shopService;

    @ApiOperation(value = "添加购物车")
    @PostMapping("/saveShop")
    public Response saveShop(HttpServletRequest request, @RequestBody Shop shop){
        LoginResult loginResult = SessionUtil.getSession(request, shop.getToken());
        String userid = String.valueOf(loginResult.getUserId());
        shop.setCreateBy(userid);
        shop.setLastModifiedBy(userid);
        return shopService.saveShop(shop);
    }
}
