package com.careerit.iplstats.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class TeamStatsDto {

      private String team;
      private String teamName;
      private long count;
      private double amount;

      public TeamStatsDto(String team, String teamName, long count, double amount) {
            this.team = team;
            this.teamName = teamName;
            this.count = count;
            this.amount = amount;
      }

}
