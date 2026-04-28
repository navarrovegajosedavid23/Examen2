package com.upiiz.examen2.controllers;

import com.upiiz.examen2.services.UsuarioServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SpringConfig {

    @Autowired
    @Lazy
    UsuarioServiceImpl usuarioServiceImpl;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception
    {
        http

            .csrf(csrf -> csrf
                .ignoringRequestMatchers("/sendEmail/RecuperarContrasenia")
            )
            .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/auth/**", "/css/**", "/js/**", "/dist/**", "/plugins/**", "/webjars/**", "/sendEmail/RecuperarContrasenia").permitAll()
                        .anyRequest().authenticated()
            )
            .formLogin(login -> login
                        .loginPage("/auth/MostrarInicioSesion")
                        .loginProcessingUrl("/auth/MostrarInicioSesion")
                        .defaultSuccessUrl("/home/MostrarInicio",true)
                        .permitAll()   
            )
            .logout(logout -> logout
                .logoutUrl("/logout")
                .logoutSuccessUrl("/auth/RegistroUsuarios/login?logout")
                .permitAll()
            );
        
        return http.build();

    }

    @Bean
    public PasswordEncoder passwordEncoder()
    {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public DaoAuthenticationProvider authenticationProvider()
    {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider((UserDetailsService) usuarioServiceImpl);
        authProvider.setPasswordEncoder(passwordEncoder());
        return authProvider;
    }

    
}
