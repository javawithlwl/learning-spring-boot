package com.careerit.sc.dii;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import java.util.ArrayList;
import java.util.Arrays;

@ComponentScan(basePackages = "com.careerit.sc.dii")
public class Manager {

  public static void main(String[] args) {
    int[] arr = { 1, 2, 3, 4, 5 };
    ApplicationContext context = new AnnotationConfigApplicationContext(Manager.class);
    NumberOperations numberOperations = context.getBean(NumberOperations.class);
    int res = numberOperations.searchElements(arr, 3);
    System.out.println("Result is :" + res);

    Arrays.asList(context.getBeanDefinitionNames()).stream().forEach(ele->{
      System.out.println(ele);
    });

  }

}
