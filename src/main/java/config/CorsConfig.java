package config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**") // Apply CORS configuration to all endpoints
                .allowedOrigins("*") // Set your allowed origins (e.g., http://localhost:4200)
                .allowedMethods("GET", "POST", "PUT", "DELETE") // Set allowed HTTP methods
                .allowedHeaders("*"); // Set allowed headers
        // You can also set other CORS configurations as needed
    }
}
