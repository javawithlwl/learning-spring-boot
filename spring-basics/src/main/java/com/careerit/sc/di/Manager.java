package com.careerit.sc.di;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@ComponentScan(basePackages = "com.careerit.sc.di")
public class Manager {

  public static void main(String[] args) {

    //ApplicationContext context = new ClassPathXmlApplicationContext("user-beans.xml");

    ApplicationContext context = new AnnotationConfigApplicationContext(Manager.class);
    UserService userService = context.getBean(UserService.class);
    AppUser user = userService.login("krish", "krish123");
    if (user != null) {
      System.out.println("Welcome " + user.getUsername());
    }else{
      System.out.println("Invalid username or password");
    }
  }
}
