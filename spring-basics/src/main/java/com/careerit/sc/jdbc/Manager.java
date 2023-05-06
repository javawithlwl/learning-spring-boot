package com.careerit.sc.jdbc;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

@ComponentScan(basePackages = "com.careerit.sc.jdbc")
public class Manager {

  public static void main(String[] args) {
    ApplicationContext applicationContext = new AnnotationConfigApplicationContext(Manager.class);
    PlayerService playerService = applicationContext.getBean(PlayerService.class);
    playerService.showPlayerCount();
  }
}
