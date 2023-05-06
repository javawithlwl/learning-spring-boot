package com.careerit.springbootbasics.dao;

import com.careerit.springbootbasics.domain.Player;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class PlayerDaoImpl implements PlayerDao {

  private final JdbcTemplate jdbcTemplate;

  @Override
  public List<Player> getPlayers() {
      return jdbcTemplate.query("select name,country,amount from player",(rs,rowNum)->{
          Player player = new Player();
          player.setName(rs.getString("name"));
          player.setCountry(rs.getString("country"));
          player.setAmount(rs.getDouble("amount"));
          return player;
      });
  }
}
