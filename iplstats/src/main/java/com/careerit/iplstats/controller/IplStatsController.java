package com.careerit.iplstats.controller;

import com.careerit.iplstats.dto.RoleStatDto;
import com.careerit.iplstats.dto.TeamStatsDto;
import com.careerit.iplstats.service.IplStatsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/stats")
public class IplStatsController {

  @Autowired
  private IplStatsService iplStatsService;

  @GetMapping("/team")
  public ResponseEntity<List<TeamStatsDto>> getTeamStat() {
    return ResponseEntity.ok(iplStatsService.getTeamStats());
  }

  @GetMapping("/role")
  public ResponseEntity<List<RoleStatDto>> getRoleStat() {
    return ResponseEntity.ok(iplStatsService.getRoleStat());
  }
  @GetMapping("/team/names")
  public ResponseEntity<List<String>> getTeamNames(){
    return ResponseEntity.ok(iplStatsService.getTeamNames());
  }


}
