package com.careerit.sc.basics;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Manager {

  public static void main(String[] args) {

    ApplicationContext applicationContext = new ClassPathXmlApplicationContext("greetings.xml");
    GreetingService greetings = applicationContext.getBean("greetings",GreetingService.class);
    System.out.println(greetings.wish("Krish"));

//    GreetingService greetings = new CongratulationGreeting();
//    String message = greetings.wish("Krish");
//    System.out.println(message);
  }

}
