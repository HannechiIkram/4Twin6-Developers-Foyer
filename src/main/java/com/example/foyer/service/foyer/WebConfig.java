package com.example.foyer.service.foyer;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
public void addCorsMappings(CorsRegistry registry) {
    registry.addMapping("/api/**")
            .allowedOrigins("http://192.168.1.11:4201") // Autoriser uniquement les requêtes provenant de votre application Angular
            .allowedMethods("GET", "POST", "PUT", "DELETE")
            .allowedHeaders("*");
}
}
