package com.careerit.sc.basics;

public class BirthdayGreetings implements  GreetingService {

      @Override
      public String wish(String name) {
           return "Happy Birthday "+name;
      }
}
