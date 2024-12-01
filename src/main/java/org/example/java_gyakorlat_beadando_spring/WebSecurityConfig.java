package org.example.java_gyakorlat_beadando_spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled = true, proxyTargetClass = true)
public class WebSecurityConfig {

    @Autowired
    private UserDetailsService userDetailsService;
    @Bean
    public static PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.csrf(csrf -> csrf.disable())
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/", "/registration", "/css/**", "/js/**", "/images/**","/resources/**", "/registration_validation", "/index", "/kapcsolat", "kapcsolat_success", "/api/**").permitAll()
                        .requestMatchers("/", "/registration", "/css/**", "/js/**", "/images/**","/resources/**", "/registration_validation").authenticated()// Engedélyezett nyilvános oldala
                        .requestMatchers("/admin/**").hasRole("ADMIN")
                                .requestMatchers("/resources/**", "/","/home", "/varosok", "/index").authenticated()
                                .requestMatchers("/resources/**", "/","/").authenticated()
                )
                .formLogin(
                        form -> form
                                .defaultSuccessUrl("/home").permitAll()
                )
                .logout(logout -> logout
                        .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                        .logoutUrl("/logout")  // Kijelentkezés URL
                        .logoutSuccessUrl("/")  // Kijelentkezés után visszairányít a főoldalra
                );

        return http.build();
    }
    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration configuration) throws Exception {
        return configuration.getAuthenticationManager();
    }

}
