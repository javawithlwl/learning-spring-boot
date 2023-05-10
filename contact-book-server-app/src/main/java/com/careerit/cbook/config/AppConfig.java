package com.careerit.cbook.config;

import io.swagger.v3.oas.models.OpenAPI;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI().info(new io.swagger.v3.oas.models.info.Info()
                .title("Contact Book Application API")
                .description("Contact Book application with Spring Boot RESTful service using springdoc-openapi and OpenAPI 3.")
                .version("v0.0.1")
                .termsOfService("http://swagger.io/terms/")
                .license(new io.swagger.v3.oas.models.info.License().name("Apache 2.0")
                        .url("http://springdoc.org")));
    }

}
