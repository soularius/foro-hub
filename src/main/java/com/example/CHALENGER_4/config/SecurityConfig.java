package com.example.CHALENGER_4.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable()) // Desactiva CSRF para simplificar el desarrollo
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/swagger-ui/**", "/v3/api-docs/**").permitAll() // Swagger permitido
                        .anyRequest().authenticated() // Protege todo lo demás
                )
                .formLogin(login -> login
                        .defaultSuccessUrl("/", true) // Redirige al Home tras login exitoso
                )
                .logout(logout -> logout
                        .logoutUrl("/logout") // URL para logout
                        .logoutSuccessUrl("/login") // Redirige al login tras logout
                        .permitAll() // Permite acceso público a la URL de logout
                )
                .httpBasic(Customizer.withDefaults());

        return http.build();
    }


    @Bean
    public InMemoryUserDetailsManager userDetailsService(PasswordEncoder passwordEncoder) {
        UserDetails user = User.builder()
                .username("user") // Cambia según tu necesidad
                .password(passwordEncoder.encode("c0372f7c-fa9a-45dd-a830-20d883fb2f10")) // Contraseña codificada
                .roles("USER")
                .build();
        return new InMemoryUserDetailsManager(user);
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}