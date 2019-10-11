package com.neusoft.bookstore.file.service;

import com.neusoft.bookstore.base.Response;
import org.springframework.web.multipart.MultipartFile;

/**
 * 文件相关接口
 */
public interface FileService {
    /**
     * 上传文件
     * @param file
     * @return
     */
    Response uploadFile(MultipartFile file);
}
