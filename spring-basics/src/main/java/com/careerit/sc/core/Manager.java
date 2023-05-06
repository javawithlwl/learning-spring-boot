package com.careerit.sc.core;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ImportResource;

@ComponentScan(basePackages = "com.careerit.sc.core")
//@ImportResource("classpath:product-beans.xml")
public class Manager {
  public static void main(String[] args) {
    ApplicationContext context = new AnnotationConfigApplicationContext(Manager.class);
    ProductUtil productUtil1 = context.getBean(ProductUtil.class);
    ProductUtil productUtil2 = context.getBean(ProductUtil.class);
    System.out.println(productUtil1);
    System.out.println(productUtil2);

  }
}
