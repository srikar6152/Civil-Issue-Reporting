package com.civrt.app.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import java.util.Arrays;

@Configuration
public class CorsConfig {

    // Allow multiple origins separated by commas
    @Value("${app.cors.allowedOrigins}")
    private String allowedOrigins;

    @Bean
    public CorsFilter corsFilter() {
        CorsConfiguration c = new CorsConfiguration();

        // Allow credentials + cookies
        c.setAllowCredentials(true);

        // Allow frontend origins (localhost + deployed frontend)
        c.setAllowedOrigins(Arrays.asList(allowedOrigins.split(",")));

        // Allow all headers + methods
        c.addAllowedHeader("*");
        c.addAllowedMethod("*");

        // Apply to API
        UrlBasedCorsConfigurationSource src = new UrlBasedCorsConfigurationSource();
        src.registerCorsConfiguration("/**", c);

        return new CorsFilter(src);
    }
}
