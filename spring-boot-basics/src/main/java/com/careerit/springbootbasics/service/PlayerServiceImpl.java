package com.careerit.springbootbasics.service;

import com.careerit.springbootbasics.dao.PlayerDao;
import com.careerit.springbootbasics.domain.Player;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class PlayerServiceImpl implements  PlayerService {

  private final PlayerDao playerDao;
  @Override
  public List<Player> getPlayers() {
    List<Player> list = playerDao.getPlayers();
    log.info("Player count is :{}",list.size());
    return list;
  }
}
