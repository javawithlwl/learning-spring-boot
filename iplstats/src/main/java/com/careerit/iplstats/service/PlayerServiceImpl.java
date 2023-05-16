package com.careerit.iplstats.service;

import com.careerit.iplstats.domain.Player;
import com.careerit.iplstats.domain.TeamDetails;
import com.careerit.iplstats.dto.PlayerDto;
import com.careerit.iplstats.repo.PlayerRepo;
import com.careerit.iplstats.repo.TeamDetailsRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class PlayerServiceImpl implements  PlayerService{

  private final PlayerRepo playerRepo;
  private final TeamDetailsRepo teamDetailsRepo;

  @Override
  public List<Player> addPlayers(List<PlayerDto> players) {
    Map<String,List<Player>> map = players.stream()
                                   .collect(Collectors.groupingBy(PlayerDto::getTeam,
                                         Collectors.mapping(PlayerDto::toPlayer,Collectors.toList())));
    List<Player> resList = new ArrayList<>();
    map.forEach((k,v)->{
      log.info("Saving players of team :{} and has {} players ",k,v.size());
      TeamDetails teamDetails = teamDetailsRepo.findById(k).orElseThrow(()->new IllegalArgumentException("Team not found with id :"+k));
      v.forEach(e->e.setTeamDetails(teamDetails));
      resList.addAll(playerRepo.saveAll(v));
    });
    log.info("Total players saved :{}",resList.size());
    return resList;
  }
}
