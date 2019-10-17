package com.neusoft.bookstore.file.mapper;

import com.neusoft.bookstore.file.model.File;
import com.neusoft.bookstore.goods.model.Goods;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface FileMapper {
    //保存文件
    void saveFile(Goods goods);
    //查询
    List<File> listFile(File file);
    //根据id删除文件
    void deleteFile(File file);
    //根据商品删除文件
    void delFileByGoods(Goods goods);
}