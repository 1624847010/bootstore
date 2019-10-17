package com.neusoft.bookstore.shuffling.controller;

import com.neusoft.bookstore.base.Response;
import com.neusoft.bookstore.shuffling.model.Shuffling;
import com.neusoft.bookstore.shuffling.service.ShufflingService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Api(description = "轮播图管理")
@RestController
@RequestMapping("shuffling")
public class ShufflingController {
    @Autowired
    private ShufflingService shufflingService;

    /**
     * 新增轮播图
     * @param shuffling
     * @return
     */
    @PostMapping("/saveBanner")
    @ApiOperation(value = "新增轮播图")
    public Response saveBanner(@RequestBody Shuffling shuffling){
        return shufflingService.saveBanner(shuffling);
    }
    /**
     * 分页查询轮播图
     * @param shuffling
     * @return
     */
    @PostMapping("/listShufflingByPage")
    @ApiOperation(value = "分页查询轮播图")
    public Response listShufflingByPage(@RequestBody Shuffling shuffling){
        return shufflingService.listShufflingByPage(shuffling);
    }
    /**
     * 删除轮播图
     * @param shuffling
     * @return
     */
    @PostMapping("/deleteShuffling")
    @ApiOperation(value = "删除轮播图")
    public Response deleteShuffling(@RequestBody Shuffling shuffling){
        List<Long> list = shuffling.getList();
        return shufflingService.deleteShuffling(list);
    }
    /**
     * 修改轮播图状态
     * @param shuffling
     * @return
     */
    @PostMapping("/updateShufflingStatus")
    @ApiOperation(value = "修改轮播图状态")
    public Response updateShufflingStatus(@RequestBody Shuffling shuffling){
        return shufflingService.updateShufflingStatus(shuffling);
    }
}
