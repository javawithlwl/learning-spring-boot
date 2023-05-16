package com.careerit.iplstats.service;

import com.careerit.iplstats.domain.PlayerStatsDto;
import com.careerit.iplstats.dto.RoleStatDto;
import com.careerit.iplstats.dto.TeamStatsDto;
import com.careerit.iplstats.repo.PlayerRepo;
import com.careerit.iplstats.repo.TeamDetailsRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class IplStatServiceImpl implements IplStatsService{

  private final PlayerRepo playerRepo;
  private final TeamDetailsRepo teamDetailsRepo;

  @Override
  public List<TeamStatsDto> getTeamStats() {
    return null;
  }

  @Override
  public List<RoleStatDto> getRoleStat() {
    return null;
  }

  @Override
  public List<PlayerStatsDto> getTopPaidPlayers(int n) {
    return null;
  }
}
