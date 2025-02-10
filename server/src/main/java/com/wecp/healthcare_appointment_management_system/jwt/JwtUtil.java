package com.wecp.healthcare_appointment_management_system.jwt;

import com.wecp.healthcare_appointment_management_system.entity.User;
import com.wecp.healthcare_appointment_management_system.repository.UserRepository;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;


@Component
public class JwtUtil {

    @Value("${jwt.secret}")
    private String secret;

    public String extractUsername(String token) {
        return extractClaim(token, Claims::getSubject);
    }

    // Other methods to extract expiration, generate token, validate token

    public String generateToken(UserDetails userDetails) {
        Map<String, Object> claims = new HashMap<>();
        // Add any claims if needed
        return createToken(claims, userDetails.getUsername());
    }

    private String createToken(Map<String, Object> claims, String subject) {
        long nowMillis = System.currentTimeMillis();
        long expMillis = nowMillis + 1000 * 60 * 60 * 10; // 10 hours

        return Jwts.builder()
            .setClaims(claims)
            .setSubject(subject)
            .setIssuedAt(new Date(nowMillis))
            .setExpiration(new Date(expMillis))
            .signWith(SignatureAlgorithm.HS256, secret)
            .compact();
    