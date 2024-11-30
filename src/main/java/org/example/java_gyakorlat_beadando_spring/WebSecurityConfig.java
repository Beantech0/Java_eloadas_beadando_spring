package org.example.java_gyakorlat_beadando_spring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class WebSecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/", "/register", "/css/**", "/js/**", "/images/**").permitAll()  // Engedélyezett nyilvános oldalak
                        .anyRequest().authenticated() // Minden más oldalhoz autentikáció szükséges
                )
                .formLogin(login -> login
                        .loginPage("/login")  // Bejelentkezési oldal
                        .defaultSuccessUrl("/")  // Sikeres bejelentkezés után visszairányít a főoldalra
                        .permitAll()
                )
                .logout(logout -> logout
                        .logoutUrl("/logout")  // Kijelentkezés URL
                        .logoutSuccessUrl("/")  // Kijelentkezés után visszairányít a főoldalra
                );

        return http.build();
    }
}
