package com.careerit.iplstats.repo;

import com.careerit.iplstats.domain.TeamDetails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeamDetailsRepo extends JpaRepository<TeamDetails, String> {
}
