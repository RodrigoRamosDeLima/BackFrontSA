package com.senai.liquidsa.util;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SignatureException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@Component
public class LoginUtil {

    private final String secret;
    private final SecretKeySpec secretKeySpec;

    public LoginUtil(@Value("${spring.security.user.password}") String secret) {
        this.secret = secret;
        this.secretKeySpec = new SecretKeySpec(this.secret.getBytes(StandardCharsets.UTF_8), "HmacSHA256");
    }

    public String generateToken(String login) {
        Map<String, Object> claims = new HashMap<>();
        return createToken(claims, login);
    }

    private String createToken(Map<String, Object> claims, String subject) {
        return Jwts.builder()
                .claims(claims)
                .subject(subject)
                .issuedAt(new Date(System.currentTimeMillis()))
                .expiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 10)) // 10 hours
//                .expiration(new Date(System.currentTimeMillis() + 1000 * 60 * 2)) // 10 hours
                .signWith(secretKeySpec)
                .compact();
    }

    public boolean isTokenValid(String token, String username) {
        String extractedUsername = extractLogin(token);
        return Objects.equals(extractedUsername, username) && isValidToken(token);
    }

    public boolean isTokenValid(String token) {
        if (token == null) return false;

        return isValidToken(token.replace("Bearer ", ""));
    }

    public String extractLogin(String token) {
        try {
            return extractAllClaims(token.replace("Bearer ", "")).getSubject();
        } catch (ExpiredJwtException | SignatureException ignored) {
            return null;
        }
    }

    private boolean isValidToken(String token) {
        try {
            return !extractAllClaims(token).getExpiration().before(new Date());
        } catch (ExpiredJwtException | SignatureException ignored) {
            return false;
        }
    }

    private Claims extractAllClaims(String jws) throws SignatureException {
        return Jwts.parser()
                .verifyWith(secretKeySpec)
                .build()
                .parseSignedClaims(jws)
                .getPayload();
    }

    public String encryptPassword(String password) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("SHA-512");
        md.update(secret.getBytes(StandardCharsets.UTF_8));

        return new String(md.digest(password.getBytes(StandardCharsets.UTF_8)));
    }
}
