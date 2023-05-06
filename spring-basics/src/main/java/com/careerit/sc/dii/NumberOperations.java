package com.careerit.sc.dii;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component

public class NumberOperations {


      private final Search search;
      @Autowired
      public NumberOperations(@Qualifier("linearSearch") Search search) {
        this.search = search;
      }
      public int searchElements(int[] arr,int ele) {
    	  return search.search(arr, ele);
      }
}
