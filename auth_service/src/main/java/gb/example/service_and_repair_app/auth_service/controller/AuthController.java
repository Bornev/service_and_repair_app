package gb.example.service_and_repair_app.auth_service.controller;

import gb.example.service_and_repair_app.auth_service.utils.JwtTokenProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.MediaType;


@ComponentScan(basePackages = "gb.example.service_and_repair_app.auth_service")
@RestController
@RequestMapping("/auth")
public class AuthController {
    @Autowired
    private JwtTokenProvider jwtTokenProvider;

    @PostMapping(value = "/login", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> login(@RequestParam String username, @RequestParam String password) {
        // Mock Authentication for demo purposes
        if ("user".equals(username) && "password".equals(password)) {
            String token = jwtTokenProvider.generateToken(username);
            return ResponseEntity.ok(token);
        }
        return ResponseEntity.status(401).body("Invalid credentials");
    }
}