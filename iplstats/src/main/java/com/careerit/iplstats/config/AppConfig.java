package com.careerit.iplstats.config;

import io.swagger.v3.oas.models.OpenAPI;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class AppConfig {

  @Bean
  public OpenAPI customOpenAPI() {
    return new OpenAPI().info(new io.swagger.v3.oas.models.info.Info()
        .title("IPL Stats API")
        .description("IPL Stats API for getting team stats, role stats and top paid players")
        .version("v1.0.0")
    );
  }

  @Bean
  public WebMvcConfigurer corsConfig() {
    return new WebMvcConfigurer() {
      @Override
      public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**").allowedMethods("*").allowedOrigins("*");
      }
    };
  }
}
