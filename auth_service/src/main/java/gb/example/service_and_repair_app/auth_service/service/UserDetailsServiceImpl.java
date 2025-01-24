package gb.example.service_and_repair_app.auth_service.service;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // Mock user for demonstration purposes
        if ("user".equals(username)) {
            return User.withUsername(username)
                    .password("$2a$10$TKh8H1.PFPs1xVFtTVZs5uEd1l8ChQqx1j/vW8pZ9sWnEnnH0/JKa") // "password" encoded
                    .roles("USER")
                    .build();
        } else {
            throw new UsernameNotFoundException("User not found");
        }
    }
}

