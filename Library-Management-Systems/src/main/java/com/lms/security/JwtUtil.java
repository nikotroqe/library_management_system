package com.lms.security;

import com.lms.model.User;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.Date;

@Component
public class JwtUtil implements Serializable {
    /*private final String secretKey = "your-secret-key"; // duhet të jetë një çelës i sigurt

    public String generateToken(User user) {
        return Jwts.builder()
                .setSubject(user.getUsername())
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + 86400000)) // 1 ditë
                .signWith(SignatureAlgorithm.HS256, secretKey)
                .compact();
    }

    public String extractUsername(String token) {
        return Jwts.parser()
                .setSigningKey(secretKey)
                .parseClaimsJws(token)
                .getBody()
                .getSubject();
    }*/
}
