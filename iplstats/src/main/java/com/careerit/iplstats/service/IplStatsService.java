package com.careerit.iplstats.service;

import com.careerit.iplstats.domain.PlayerStatsDto;
import com.careerit.iplstats.dto.RoleStatDto;
import com.careerit.iplstats.dto.TeamStatsDto;

import java.util.List;

public interface IplStatsService {

      List<TeamStatsDto> getTeamStats();
      List<RoleStatDto> getRoleStat();
      List<PlayerStatsDto> getTopPaidPlayers(int n);

}
