package de.dbauction.user;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.security.Key;
import java.util.Date;

@Service
@PropertySource(value = "classpath:application.properties")
public class AuthenticationService {
    private final Key key;

    public AuthenticationService(@Value("${jwt.secret}")  String secretKey) {
        byte[] keyBytes = java.util.Base64.getDecoder().decode(secretKey);
        this.key = Keys.hmacShaKeyFor(keyBytes);
    }

    public Mono<String> generateToken(Long id) {
        return Mono.fromCallable(() -> Jwts.builder()
                .subject(id.toString())
                .issuedAt(new Date())
                .expiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 10)) // 10 hours
                .signWith(key)
                .compact());
    }
}
