package com.manong.utils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * JWT工具类
 */
public class JwtUtils {

    private static final String SECRET = "manong"; // 密钥
    private static final long EXPIRATION = 60 * 60 * 1000; // 过期时间，单位毫秒

    /**
     * 生成JWT
     * @param username 用户名
     * @return JWT字符串
     */
    public static String generateToken(String username) {
        Map<String, Object> claims = new HashMap<>();
        return createToken(claims, username);
    }

    /**
     * 从JWT中获取用户名
     * @param token JWT字符串
     * @return 用户名
     */
    public static String getUsernameFromToken(String token) {
        return getClaimsFromToken(token).getSubject();
    }

    /**
     * 验证JWT是否有效
     * @param token JWT字符串
     * @param username 用户名
     * @return 是否有效
     */
    public static boolean validateToken(String token, String username) {
        String usernameInToken = getUsernameFromToken(token);
        return usernameInToken.equals(username) && !isTokenExpired(token);
    }

    /**
     * 判断JWT是否过期
     * @param token JWT字符串
     * @return 是否过期
     */
    private static boolean isTokenExpired(String token) {
        Date expiration = getClaimsFromToken(token).getExpiration();
        return expiration.before(new Date());
    }

    /**
     * 创建JWT
     * @param claims 声明
     * @param subject 主题
     * @return JWT字符串
     */
    private static String createToken(Map<String, Object> claims, String subject) {
        return Jwts.builder()
                .setClaims(claims)
                .setSubject(subject)
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION))
                .signWith(SignatureAlgorithm.HS512, SECRET)
                .compact();
    }

    /**
     * 从JWT中获取声明
     * @param token JWT字符串
     * @return 声明
     */
    private static Claims getClaimsFromToken(String token) {
        return Jwts.parser()
                .setSigningKey(SECRET)
                .parseClaimsJws(token)
                .getBody();
    }
}

