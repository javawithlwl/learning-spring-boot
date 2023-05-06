package com.careerit.sc.lc;

import jakarta.annotation.PostConstruct;

import java.util.UUID;

public class Product {

  private UUID id;
  private String name;
  private double price;

  @PostConstruct
  public void init() {
    if (this.id == null) {
      this.id = UUID.randomUUID();
    }
  }
}
