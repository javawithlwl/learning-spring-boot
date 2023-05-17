package com.careerit.iplstats.repo;

import com.careerit.iplstats.domain.TeamDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TeamDetailsRepo extends JpaRepository<TeamDetails, String> {
  @Query("select t.team from TeamDetails t")
  List<String> findTeamNames();
}
