package com.careerit.iplstats.service;

import com.careerit.iplstats.domain.TeamDetails;
import com.careerit.iplstats.repo.TeamDetailsRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class TeamDetailsServiceImpl implements  TeamDetailsService{

  private final TeamDetailsRepo teamDetailsRepo;

  @Override
  public List<TeamDetails> addTeamDetails(List<TeamDetails> teamDetails) {
        log.info("Saving team details of size :{}",teamDetails.size());
        return teamDetailsRepo.saveAll(teamDetails);
  }
}
