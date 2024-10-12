package energy.dubhacks.reliefApp.config;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.context.annotation.Configuration;


@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            // Disable CSRF for simplicity; enable it in production environments
            .csrf(csrf -> csrf.disable())
            
            // Configure authorization rules
            .authorizeHttpRequests(auth -> auth
                // Permit all requests
                .anyRequest().permitAll()
            )
            
            // Enable HTTP Basic Authentication
            .httpBasic(org.springframework.security.config.Customizer.withDefaults());

        return http.build();
    }
}