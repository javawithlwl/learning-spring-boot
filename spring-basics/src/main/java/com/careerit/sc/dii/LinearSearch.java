package com.careerit.sc.dii;

import org.springframework.stereotype.Component;

@Component
public class LinearSearch implements Search{

    @Override
    public int search(int[] arr, int ele) {
      System.out.println("Linear search algorithm");
      return 0;
    }
}
