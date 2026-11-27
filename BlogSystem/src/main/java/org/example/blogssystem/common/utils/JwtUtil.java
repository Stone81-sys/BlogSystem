package org.example.blogssystem.common.utils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtParserBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.StringUtils;

import javax.crypto.SecretKey;
import java.util.Date;
import java.util.Map;

@Slf4j
public class JwtUtil {
    //密钥
    private static String secret="8yxuAp9cZ458SVqOdMnZBZvMq09b0IsxEiGAjAR8yGA=";
    //限制时间
    public final static long expiration=60*60*1000;
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

    //验证密钥
    public static Claims parseJWT(String jwt) {
        if (!StringUtils.hasLength(jwt)) {
            return null;
        }
        //创建解析器, 设置签名密钥
        JwtParserBuilder jwtParserBuilder =
                Jwts.parserBuilder().setSigningKey(secretKey);
        Claims claims = null;
        try {
            //解析token
            claims = jwtParserBuilder.build().parseClaimsJws(jwt).getBody();
        } catch (Exception e) {
            //签名验证失败
            log.error("解析令牌错误,jwt:{}", jwt);
        }
        return claims;
    }

}
