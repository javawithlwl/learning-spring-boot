package com.careerit.sc.dii;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
public class BinarySearch implements Search {

  @Override
  public int search(int[] arr, int ele) {
    System.out.println("Binary search algorithm");
    return 0;
  }
}
