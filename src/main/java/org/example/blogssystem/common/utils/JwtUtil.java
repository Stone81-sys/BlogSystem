package org.example.blogssystem.common.utils;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;

import javax.crypto.SecretKey;
import java.util.Base64;
import java.util.Date;
import java.util.Map;

public class JwtUtil {
    //密钥
    private static String secret="8yxuAp9cZ458SVqOdMnZBZvMq09b0IsxEiGAjAR8yGA=";
    //限制时间
    public final static long expiration=10*60*1000;
    //生成安全密钥
    private static SecretKey secretKey=Keys.hmacShaKeyFor(Decoders.BASE64.decode(secret));

    //生成令牌
    public static String genJwt(Map<String,Object> claim){
        String jwt= Jwts.builder()
                .setClaims(claim)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis()+expiration))
                .signWith(secretKey)
                .compact();
        return jwt;
    }
}
