package gb.example.service_and_repair_app.auth_service.utils;

import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class JwtTokenProvider {

    // Загрузка секретного ключа из application.properties
    @Value("${jwt.secret}")
    private String jwtSecret;

    private final long jwtExpiration = 86400000; // 1 день

    // Метод для генерации JWT токена
    public String generateToken(String username) {
        Date now = new Date();
        Date expiryDate = new Date(now.getTime() + jwtExpiration);

        return Jwts.builder()
                .claim("sub", username)
                .claim("iat", now)
                .claim("exp", expiryDate)
                .signWith(Keys.hmacShaKeyFor(jwtSecret.getBytes()))
                .compact();
    }


    // Метод для проверки JWT токена
    public boolean validateToken(String token) {
        try {
            Jwts.parser()
                    .verifyWith(Keys.hmacShaKeyFor(jwtSecret.getBytes()))
                    .build()
                    .parse(token);
            return true;
        } catch (Exception e) {
            System.err.println("Ошибка проверки JWT: " + e.getMessage());
            return false;
        }
    }

    // Метод для получения имени пользователя из JWT токена
    public String getUsernameFromToken(String token) {
        return Jwts.parser()
                .verifyWith(Keys.hmacShaKeyFor(jwtSecret.getBytes()))
                .build()
                .parseSignedClaims(token)
                .getPayload()
                .get("sub", String.class);
    }

    public void setJwtSecret(String jwtSecret) {
        this.jwtSecret = jwtSecret;
    }

    public String getJwtSecret() {
        return jwtSecret;
    }

}
