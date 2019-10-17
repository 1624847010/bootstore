package com.neusoft.bookstore.file.controller;

import com.neusoft.bookstore.base.Response;
import com.neusoft.bookstore.file.model.File;
import com.neusoft.bookstore.file.service.FileService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@Api(description = "上传文件相关控制器")
@RestController
@RequestMapping("file")
public class FileController {
    @Autowired
    private FileService fileService;

    /**
     * 上传文件
     * @param file
     * @return
     */
    @ApiOperation(value = "上传文件")
    @PostMapping("/uploadFile")
    public Response uploadFile(MultipartFile file){
        return fileService.uploadFile(file);
    }

    /**
     * 删除文件
     * @param file
     * @return
     */
    @ApiOperation(value = "删除文件")
    @PostMapping("/delFile")
    public Response delFile(@RequestBody File file){
        return fileService.delFile(file);
    }
}
