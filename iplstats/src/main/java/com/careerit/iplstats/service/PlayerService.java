package com.careerit.iplstats.service;

import com.careerit.iplstats.domain.Player;
import com.careerit.iplstats.dto.PlayerDto;

import java.util.List;

public interface PlayerService {
    List<Player> addPlayers(List<PlayerDto> players);
}
