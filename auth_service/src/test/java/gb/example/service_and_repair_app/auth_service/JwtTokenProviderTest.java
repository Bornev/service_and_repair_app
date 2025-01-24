//Интеграционные тест
package gb.example.service_and_repair_app.auth_service;

//import gb.example.service_and_repair_app.auth_service.TestConfig;
import gb.example.service_and_repair_app.auth_service.utils.JwtTokenProvider;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest(classes = {TestConfig.class, JwtTokenProvider.class})
@TestPropertySource(locations = "classpath:application-test.properties")
public class JwtTokenProviderTest {

    @Autowired
    private JwtTokenProvider jwtTokenProvider;

    @BeforeEach
    public void setUp() {
        jwtTokenProvider.setJwtSecret("your_test_secret_key_here");
    }

    @Test
    public void testGenerateAndValidateToken() {
        String token = jwtTokenProvider.generateToken("testuser");
        assertTrue(jwtTokenProvider.validateToken(token));
    }

    @Test
    public void testGetUsernameFromToken() {
        String token = jwtTokenProvider.generateToken("testuser");
        String username = jwtTokenProvider.getUsernameFromToken(token);
        assertEquals("testuser", username);
    }

    @Test
    public void testInvalidToken() {
        String invalidToken = "invalidToken";
        assertFalse(jwtTokenProvider.validateToken(invalidToken));
    }

    @Test
    public void testExpiredToken() {
        // Создаем токен с истекшим сроком действия
        String expiredToken = Jwts.builder()
                .claim("sub", "testuser")
                .claim("iat", new Date(System.currentTimeMillis() - 1000))
                .claim("exp", new Date(System.currentTimeMillis() - 500))
                .signWith(Keys.hmacShaKeyFor(jwtTokenProvider.getJwtSecret().getBytes()))
                .compact();

        assertFalse(jwtTokenProvider.validateToken(expiredToken));
    }
}




////Юнит-тест
//
//package gb.example.service_and_repair_app.auth_service;
//
//import gb.example.service_and_repair_app.auth_service.utils.JwtTokenProvider;
//import org.junit.jupiter.api.Test;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//public class JwtTokenProviderTest {
//
//    private final JwtTokenProvider jwtTokenProvider = new JwtTokenProvider();
//
//    @Test
//    public void testGenerateAndValidateToken() {
//        String token = jwtTokenProvider.generateToken("testuser");
//        assertTrue(jwtTokenProvider.validateToken(token));
//        assertEquals("testuser", jwtTokenProvider.getUsernameFromToken(token));
//    }
//
//    @Test
//    public void testInvalidToken() {
//        assertFalse(jwtTokenProvider.validateToken("invalidToken"));
//    }
//}
