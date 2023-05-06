package com.careerit.sc.basics;

public class CongratulationGreeting implements  GreetingService{
  @Override
  public String wish(String name) {
    return "Congratulation "+name;
  }
}
