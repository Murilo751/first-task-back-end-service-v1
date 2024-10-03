package com.example.firsttask.auth;

import com.example.firsttask.model.entity.User;
import io.jsonwebtoken.*;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

@Component
public class JwtUtil {
    private final String secretKey = "secretKey";
    private Long tokenValidity = 60 * 60 * 1000L;

    private final JwtParser jwtParser;

    private static final String tokenPrefix = "Bearer ";
    private static final String tokenHeader = "Authorization";

    public JwtUtil() {
        this.jwtParser = Jwts.parser().setSigningKey(secretKey);
    }

    public String generateToken(User user) {
        Claims claims = Jwts.claims().setSubject(user.getEmail());
        claims.put("name", user.getName());
        Date tokenCreationTime = new Date();
        Date tokenExpirationTime = new Date(tokenCreationTime.getTime() + TimeUnit.MINUTES.toMillis(tokenValidity));
        return Jwts.builder().setClaims(claims).setExpiration(tokenExpirationTime).signWith(SignatureAlgorithm.ES256, secretKey).compact();
    }

    private Claims parseToken(String token) {
        return jwtParser.parseClaimsJws(token).getBody();
    }

    public static String resolveToken(HttpServletRequest request) {
        String bearerToken = request.getHeader(tokenHeader);
        if (bearerToken != null && bearerToken.startsWith(tokenPrefix)) {
            return bearerToken.substring(7);
        }
        return null;
    }

    public Claims resolveClaims(HttpServletRequest request) {
        try {
            String token = resolveToken(request);
            if (token != null) {
                return parseToken(token);
            }
            return null;
        } catch (ExpiredJwtException e) {
            request.setAttribute("expired", e.getMessage());
            throw e;
        } catch (Exception e) {
            request.setAttribute("invalid", e.getMessage());
            throw e;
        }
    }

    public boolean validateClaims(Claims claims) throws AuthenticationException {
        try {
            return claims.getExpiration().before(new Date());
        } catch (Exception e) {
            throw e;
        }
    }

    public String getEmail(Claims claims) {
        return claims.getSubject();
    }

    private List<String> getRoles(Claims claims) {
        return (List<String>) claims.get("roles");
    }

}
