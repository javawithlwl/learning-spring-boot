package com.careerit.sc.jdbc;

import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@RequiredArgsConstructor
@Repository
public class PlayerDao{

      private final JdbcTemplate jdbcTemplate;

      public int count() {
    	  return jdbcTemplate.queryForObject("select count(*) from player", Integer.class);
      }
}
