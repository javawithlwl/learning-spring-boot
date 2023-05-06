package com.careerit.sc.lc;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import java.util.Arrays;

@ComponentScan(basePackages = "com.careerit.sc.lc")
public class Manager {
  public static void main(String[] args) {
    ConfigurableApplicationContext context = new AnnotationConfigApplicationContext(Manager.class);
    SeedDataUtil seedDataUtil = context.getBean(SeedDataUtil.class);
    seedDataUtil.show();
    Arrays.asList(context.getBeanDefinitionNames()).stream().forEach(ele->{
      System.out.println(ele);
    });
    context.close();
  }
}
