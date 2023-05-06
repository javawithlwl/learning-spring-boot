package com.careerit.sc.lc;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

@Component
public class SeedDataUtil {
      @PostConstruct
      public void init(){
          System.out.println("Seed data is loaded");
      }
      public void show(){
          System.out.println("Show method is called");
      }
      @PreDestroy
      public void destroy(){
          System.out.println("Destroy method is called");
      }
}
