package com.careerit.springbootbasics.dao;

import com.careerit.springbootbasics.domain.Player;

import java.util.List;

public interface PlayerDao {

    List<Player> getPlayers();
}
