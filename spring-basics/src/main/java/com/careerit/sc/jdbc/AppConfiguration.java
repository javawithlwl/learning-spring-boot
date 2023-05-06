package com.careerit.sc.jdbc;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;
import java.sql.DriverManager;

@Configuration
@PropertySource("classpath:db.properties")
public class AppConfiguration {

      @Value("${db.url}")
      private String url;
      @Value("${db.username}")
      private String username;
      @Value("${db.password}")
      private String password;

      @Bean
      public DataSource getDataSource() {
        DriverManagerDataSource driverManager = new DriverManagerDataSource();
        driverManager.setUrl(url);
        driverManager.setUsername(username);
        driverManager.setPassword(password);
        return driverManager;
      }

      @Bean
      public JdbcTemplate jdbcTemplate() {
    	  return new JdbcTemplate(getDataSource());
      }

}
