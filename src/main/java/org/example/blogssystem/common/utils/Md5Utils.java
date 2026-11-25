package org.example.blogssystem.common.utils;

import lombok.extern.slf4j.Slf4j;
import org.springframework.util.DigestUtils;

import java.nio.charset.StandardCharsets;
import java.util.UUID;

@Slf4j
public class Md5Utils {
    public static String encrypt(String password){
        String salt= UUID.randomUUID().toString().replace("-","");
        String finalpassword= DigestUtils.md5DigestAsHex((salt+password).getBytes(StandardCharsets.UTF_8));
        return salt+finalpassword;
    }

    public static Boolean verify(String inputPassword , String finalpassword){
        if(inputPassword==null){
            return false;
        }
        String salt=finalpassword.substring(0,32);
        String inputFinalpassword= DigestUtils.md5DigestAsHex((salt+inputPassword).getBytes(StandardCharsets.UTF_8));
        if((salt+inputFinalpassword).equals(finalpassword)){
            return true;
        }
        return false;

    }
}
