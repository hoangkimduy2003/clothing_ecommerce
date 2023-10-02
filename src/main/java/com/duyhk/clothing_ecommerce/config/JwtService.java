package com.duyhk.clothing_ecommerce.config;

import com.duyhk.clothing_ecommerce.entity.Users;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.util.Date;
import java.util.function.Function;

@Service
public class JwtService {
    public String generateToken(Users users) {
        Claims claims = Jwts.claims().setSubject(users.getEmail());
        claims.put("user",users);
        return Jwts.builder()
                .setClaims(claims)
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() * 1000 * 60 * 24))
                .signWith(getSiginKey(), SignatureAlgorithm.HS256)
                .compact();
    }

    public String getUsername(String token) {
        try {
            return Jwts.parserBuilder()
                    .setSigningKey(getSiginKey())
                    .build().parseClaimsJws(token)
                    .getBody()
                    .getSubject();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public String extractUserName(String token) {
        return extractClaim(token, Claims::getSubject);
    }

    private <T> T extractClaim(String token, Function<Claims, T> claimsResolvers) {
        final Claims claims = extractAllClaims(token);
        return claimsResolvers.apply(claims);
    }

    public Claims extractAllClaims(String token) {
        return Jwts
                .parserBuilder()
                .setSigningKey(getSiginKey())
                .build()
                .parseClaimsJwt(token)
                .getBody();
    }

    private Key getSiginKey() {
        byte[] key = Decoders.BASE64.decode("09765414820399157140180920032004200310112019");
        return Keys.hmacShaKeyFor(key);
    }

    public boolean isTokenValid(String token, UserDetails userDetails){
        String username = getUsername(token);
        return (username.equalsIgnoreCase(userDetails.getUsername()) && !isTokenExpired(token));
    }

    public boolean isTokenExpired(String token){
        return extractClaim(token, Claims :: getExpiration).before(new Date());
    }
}
