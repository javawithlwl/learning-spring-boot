package com.careerit.iplstats.controller;

import com.careerit.iplstats.domain.TeamDetails;
import com.careerit.iplstats.service.IplStatsService;
import com.careerit.iplstats.service.TeamDetailsService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/team")
@RequiredArgsConstructor
public class TeamDetailsController {

      private final TeamDetailsService teamDetailsService;

      @PostMapping("/all")
      public ResponseEntity<List<TeamDetails>> addTeamDetails(@RequestBody List<TeamDetails> teamDetails){
            return ResponseEntity.ok(teamDetailsService.addTeamDetails(teamDetails));
      }
}
