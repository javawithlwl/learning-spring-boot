package com.careerit.iplstats.dto;

import com.careerit.iplstats.domain.Player;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PlayerDto {

  private String name;
  private String role;
  private String country;
  private double amount;
  private String team;

  public Player toPlayer() {
    Player player = new Player();
    player.setName(name);
    player.setRole(role);
    player.setCountry(country);
    player.setAmount(amount);
    return player;
  }
}
