package com.example.config;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import java.security.Key;
import java.util.Date;
import java.util.function.Function;

public class JwtUtil {

    // Use a valid Base64 encoded secret key (256-bit)
    private static final String SECRET_KEY = "uY6XgN5Hqz8hUoMz/DwV6r5B8NCEcJ4WvBd6Mx7dmDY="; // Base64 encoded key

    private Key getSigningKey() {
        return Keys.hmacShaKeyFor(Decoders.BASE64.decode(SECRET_KEY)); // Decoding the Base64 string
    }

    // Extracting claims from the token
    public <T> T extractClaim(String token, Function<Claims, T> claimsResolver) {
        final Claims claims = Jwts.parser() // Correct usage of the parserBuilder
                .setSigningKey(getSigningKey())  // Signing key obtained from the Base64 decoded key
                .build()
                .parseClaimsJws(token)
                .getBody();
        return claimsResolver.apply(claims);
    }

    // Generate JWT token (with expiration time, etc.)
    public String generateToken(String email) {
        return Jwts.builder()
                .setSubject(email)  // Setting the email as the subject of the token
                .setIssuedAt(new Date())  // Issued at the current time
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60))  // 1 hour expiration
                .signWith(getSigningKey())  // Sign the token with the key
                .compact();
    }
}
