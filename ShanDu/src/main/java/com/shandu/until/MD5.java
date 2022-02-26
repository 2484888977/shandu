package com.shandu.until;

import org.springframework.util.DigestUtils;

public class MD5 {
    //    spring MD5加密
    public static String Encrypted_MD5(String str){
        return DigestUtils.md5DigestAsHex(str.getBytes());
    }
}
