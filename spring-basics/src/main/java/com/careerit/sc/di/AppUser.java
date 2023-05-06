package com.careerit.sc.di;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AppUser {

      private String username;
      private String email;
      private String password;

}
