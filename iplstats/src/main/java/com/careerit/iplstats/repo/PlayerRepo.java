package com.careerit.iplstats.repo;
import com.careerit.iplstats.domain.Player;
import com.careerit.iplstats.dto.PlayerDto;
import com.careerit.iplstats.dto.RoleStatDto;
import com.careerit.iplstats.dto.TeamStatsDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PlayerRepo extends JpaRepository<Player, Long> {

      @Query("select new com.careerit.iplstats.dto.TeamStatsDto(t.team,t.teamName,count(p.name),sum(p.amount)) from Player p inner join p.teamDetails t group by t.team,t.teamName")
      List<TeamStatsDto> findTeamStat();

      @Query( value = "select p.role as role, count(p.role) as count,sum(p.amount) as totalAmount from player p group by p.role" ,nativeQuery = true)
      List<RoleStatDto> findRoleStat();

      @Query("select p from Player p where p.role = :role and p.country = :country")
      List<Player> findPlayers(@Param("role") String role,@Param("country") String country);

      @Query("select p from Player p where p.country =?1")
      List<Player> findPlayerByCountry(String country);

      @Query("select p from Player p where p.teamDetails.team =?1")
      List<Player> findByTeam(String team);
}
