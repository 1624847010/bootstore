package com.neusoft.bookstore.utils;

import org.apache.commons.codec.digest.DigestUtils;

public class MD5Util {
    public static  String encryption(String str){
        return DigestUtils.md5Hex(str);
    }
}
