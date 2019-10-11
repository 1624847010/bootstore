package com.neusoft.bookstore.file.service.impl;

import com.github.tobato.fastdfs.domain.StorePath;
import com.github.tobato.fastdfs.service.FastFileStorageClient;
import com.neusoft.bookstore.base.Response;
import com.neusoft.bookstore.file.service.FileService;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class FileServiceImpl implements FileService {
    @Autowired
    private FastFileStorageClient fastFileStorageClient;

    @Value("${fdfs.hostPort}")
    private String hostPort;

    /**
     * 上传文件
     * @param file
     * @return
     */
    //getInputStream() 返回一个InputStream，以从中读取文件的内容。用户负责关闭返回的流。
    //getSize()返回文件的大小（以字节为单位）。
    //FilenameUtils.getExtension() 获取类型（文件后缀名）
    //getOriginalFilename() 返回客户端文件系统中的原始文件名。
    @Override
    public Response uploadFile(MultipartFile file) {
        try {
           StorePath storePath = fastFileStorageClient.uploadFile(file.getInputStream(),file.getSize(),FilenameUtils.getExtension(file.getOriginalFilename()),null);
            String filePath = storePath.getFullPath();
            filePath=hostPort+filePath;
            return Response.ok(filePath,"上传成功");
        }catch (Exception e){
            return Response.error("上传失败");
        }
    }
}
