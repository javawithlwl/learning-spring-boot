package com.careerit.sc.di;


import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class SeedDataProvider {


      public List<AppUser> getUsers() {

            List<AppUser> list = new ArrayList<>();
            list.add(AppUser.builder().username("krish").email("krish@gmail.com").password("krish123").build());
            list.add(AppUser.builder().username("manoj").email("maonj@gmail.com").password("manoj123").build());
            list.add(AppUser.builder().username("charan").email("charan@gmail.com").password("charan123").build());
            list.add(AppUser.builder().username("suresh").email("suresh@gmail.com").password("suresh123").build());
            list.add(AppUser.builder().username("ramesh").email("ramesh@gmail.com").password("ramesh123").build());
            list.add(AppUser.builder().username("lokesh").email("lokesh@gmail.com").password("lokesh123").build());
            return list;
      }

}
