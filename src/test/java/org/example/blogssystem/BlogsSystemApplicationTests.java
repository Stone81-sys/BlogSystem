package org.example.blogssystem;

import io.jsonwebtoken.security.Keys;
import org.example.blogssystem.common.utils.Md5Utils;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.DigestUtils;

import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;
import java.util.UUID;

@SpringBootTest
class BlogsSystemApplicationTests {

    @Test
    void contextLoads() {
        SecretKey key = Keys.secretKeyFor(io.jsonwebtoken.SignatureAlgorithm.HS256);
        String secret = io.jsonwebtoken.io.Encoders.BASE64.encode(key.getEncoded());
        System.out.println(secret);
    }

    @Test
    void encrypt(){
        String password="123456";
        String salt= UUID.randomUUID().toString().replace("-","");
        String finalpassword= DigestUtils.md5DigestAsHex((salt+password).getBytes(StandardCharsets.UTF_8));
        System.out.println(salt + finalpassword);
    }

    @Test
    void Test(){
        System.out.println(Md5Utils.encrypt("123456"));

    }

//    @Test
//    public static Boolean verify(String inputPassword , String finalpassword){
//        if(inputPassword==null){
//            return false;
//        }
//        String salt=finalpassword.substring(0,32);
//        String inputFinalpassword= DigestUtils.md5DigestAsHex((salt+inputPassword).getBytes(StandardCharsets.UTF_8));
//        if((salt+inputFinalpassword).equals(finalpassword)){
//            System.out.println("dui");
//        }
//        return false;
//
//    }

}
