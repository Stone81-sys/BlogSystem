package org.example.blogssystem;

import io.jsonwebtoken.security.Keys;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.crypto.SecretKey;

@SpringBootTest
class BlogsSystemApplicationTests {

    @Test
    void contextLoads() {
        SecretKey key = Keys.secretKeyFor(io.jsonwebtoken.SignatureAlgorithm.HS256);
        String secret = io.jsonwebtoken.io.Encoders.BASE64.encode(key.getEncoded());
        System.out.println(secret);
    }

}
