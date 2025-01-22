package gb.example.service_and_repair_app.auth_service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class AuthServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(AuthServiceApplication.class, args);
    }
}

//
//import gb.example.service_and_repair_app.auth_service.AuthServiceApplication;
//import gb.example.service_and_repair_app.auth_service.utils.JwtTokenProvider;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
//import org.springframework.test.context.TestPropertySource;
//
//import static org.junit.jupiter.api.Assertions.assertTrue;
//
//@SpringBootTest(classes = AuthServiceApplication.class, webEnvironment = WebEnvironment.RANDOM_PORT, excludeAutoConfiguration = {org.springframework.cloud.netflix.eureka.EurekaClientAutoConfiguration.class})
//@TestPropertySource(locations = "classpath:application-test.properties")
//public class JwtTokenProviderTest {
//
//    @Autowired
//    private JwtTokenProvider jwtTokenProvider;
//
//    @Test
//    public void testGenerateAndValidateToken() {
//        String token = jwtTokenProvider.generateToken("testuser");
//        assertTrue(jwtTokenProvider.validateToken(token));
//    }
//}
