package com.cst8277.apigateway.util;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

@Component
public class JwtUtil {
    public static final String SECRET = "04f69d112eabe0a63170638bdc36f1f1cd1bddca48fc99bb2cff46643dd9c1c0";

    public void validateToken(final String token) {
        try {
            Claims claims = Jwts.parserBuilder()
                    .setSigningKey(getSignKey())
                    .build()
                    .parseClaimsJws(token)
                    .getBody();

            if (claims.getExpiration().before(new Date())) {
                throw new ExpiredJwtException(null, claims, "Token has expired");
            }

        } catch (ExpiredJwtException e) {
            throw new RuntimeException("Token has expired", e);
        } catch (Exception e) {
            throw new RuntimeException("Failed to validate token", e);
        }
    }
    private Key getSignKey() {
        byte[] keyBytes = Decoders.BASE64.decode(SECRET);
        return Keys.hmacShaKeyFor(keyBytes);
    }
}