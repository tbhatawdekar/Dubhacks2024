package energy.dubhacks.reliefApp.config;

import java.beans.Customizer;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
            .csrf(Customizer.withDefaults()).disable() // Disable CSRF for simplicity; enable in production
            .authorizeHTTPRequests()
                .antMatchers("/api/**").permitAll() // Permit all API endpoints; adjust as needed
                .anyRequest().authenticated()
            .and()
            .httpBasic(); // Use basic authentication; consider more secure methods
        return http.build();
    }
}
