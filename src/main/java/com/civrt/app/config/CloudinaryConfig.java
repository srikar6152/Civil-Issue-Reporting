
package com.civrt.app.config;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Map;

@Configuration
public class CloudinaryConfig {

    @Value("${cloudinary.cloud_name:}")
    private String cloud;

    @Value("${cloudinary.api_key:}")
    private String key;

    @Value("${cloudinary.api_secret:}")
    private String secret;

    @Bean
    public Cloudinary cloudinary() {
        Map<String, String> cfg = ObjectUtils.asMap(
            "cloud_name", cloud,
            "api_key", key,
            "api_secret", secret,
            "secure", "true"
        );
        return new Cloudinary(cfg);
    }
}
