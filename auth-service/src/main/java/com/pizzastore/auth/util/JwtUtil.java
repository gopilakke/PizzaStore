package com.pizzastore.auth.util;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Component;
import java.util.Date;

@Component
public class JwtUtil {
    private final String jwtSecret = "changeit-very-secret-key";
    private final long validityMs = 24*60*60*1000;
    public String generateToken(String username, String role){
        return Jwts.builder().setSubject(username).claim("role", role).setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis()+validityMs))
                .signWith(SignatureAlgorithm.HS256, jwtSecret).compact();
    }
}
