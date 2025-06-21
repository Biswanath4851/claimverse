package com.claimverse.authservice.security;

import com.claimverse.authservice.entity.User;
import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.util.Date;

@Service
public class JwtService {
    private static final String SECRET_KEY = "claimverse_2025_secret_verysecureclaimverse_2025";

    public String generateToken(User user){
        return Jwts.builder()
                .setSubject(user.getEmail())
                .claim("role", user.getRole().name())
                .setIssuedAt( new Date())
                .setExpiration(new Date(System.currentTimeMillis()+1000*60*60*24))
                .signWith(getSignKey(), SignatureAlgorithm.HS256)
                .compact();
    }
    private Key getSignKey() {
        return Keys.hmacShaKeyFor(SECRET_KEY.getBytes());
    }
}