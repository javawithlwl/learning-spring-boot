package com.careerit.sc.core;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class AppConfig {

      @Bean
      public ProductUtil productUtil(){
          return new ProductUtil();
      }
}
