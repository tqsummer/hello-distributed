package com.study.hello.distributed.mybatis.apiserver.test;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class JwtUtilTest {

    public static void main(String[] args) {
        String secret = "e3b0c44298fc1c149afbf4c8996fb92427ae41e4649b934ca495991b7852b855";
        long expiration = 3600L * 24 * 365 * 100;
        Map<String, Object> claims = new HashMap<>();
        String jwtToken = Jwts.builder()
                .setClaims(claims)
                .setSubject("fxq")
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + expiration * 1000))
                .signWith(Keys.hmacShaKeyFor(secret.getBytes()), SignatureAlgorithm.HS256)
                .compact();

        System.out.println(jwtToken);
    }
}
