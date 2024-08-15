package com.jwt.example.Jwt_demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableMethodSecurity(securedEnabled = true)
public class SecurityConfig {
    @Bean
    public BCryptPasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
    /*@Bean
    public UserDetailsService userDetailsService(PasswordEncoder passwordEncoder){
        var user = User.builder().username("sri").password(passwordEncoder.encode("Test@123")).roles("ADMIN", "MANAGER").build();
        var user1 = User.builder().username("msd").password(passwordEncoder.encode("msd@123")).roles("ADMIN", "MANAGER").build();
        return new InMemoryUserDetailsManager(user, user1);
    }*/

    @Bean
    public SecurityFilterChain getFilterChain(HttpSecurity http) throws Exception {
        return http.authorizeHttpRequests(httpReq -> httpReq.requestMatchers("/user/access-token")
                        .authenticated().anyRequest().permitAll()).formLogin(Customizer.withDefaults())
                .csrf(AbstractHttpConfigurer::disable)
                .httpBasic(Customizer.withDefaults())
                .build();
    }
}
