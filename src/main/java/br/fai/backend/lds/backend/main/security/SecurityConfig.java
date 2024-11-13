package br.fai.backend.lds.backend.main.security;

import io.swagger.v3.oas.models.headers.Header;
import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.annotation.web.configurers.HeadersConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import javax.swing.*;
import java.util.List;


//Essa classe vai ser lavantada sempre que rodar a aplicacao por conta do Configuration, ela nasce quando o play acontece
@Profile("sec")
@Configuration
public class SecurityConfig {
    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }

    //Precisar decorar para prova
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        // O cors habilita a requisicao do mundo externo para nossa aplicacao
        // csrf = cross-site request forgery (falsificação de solicitação entre sites)
        // AuhorizeRequets passo os endpoints que tal usuario pode acessar
        // SessionManager.STATELESS para nao segurar  asessao do usuario
        http
            .cors(cors -> cors.configurationSource(corsConfigurationSource()))
            .csrf(AbstractHttpConfigurer::disable)
            .authorizeHttpRequests(
                    auth -> auth.requestMatchers(
                            "/listar",
                            "/swagger-ui.html",
                            "/swagger-ui/**",
                            "/v3/api-docs/**",
                            "/h2-console/**",
                            "/authenticate"
                    ).permitAll()
                     .anyRequest().authenticated()
            )
            .sessionManagement(
                    session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
            )
            .headers(
                    headers -> headers.frameOptions(
                            HeadersConfigurer.FrameOptionsConfig::sameOrigin
                    )
            );






        return http.build();
    }

    @Bean
    public CorsConfigurationSource corsConfigurationSource(){
        CorsConfiguration configuration =  new CorsConfiguration();
        configuration.applyPermitDefaultValues();
        configuration.setAllowedMethods(List.of("GET", "POST", "PUT", "OPTIONS", "HEAD", "DELETE"));

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);
        return source;
    }
}
