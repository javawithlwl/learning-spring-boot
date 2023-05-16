package com.careerit.iplstats.controller;

import com.careerit.iplstats.domain.Player;
import com.careerit.iplstats.dto.PlayerDto;
import com.careerit.iplstats.service.PlayerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/player")
@RequiredArgsConstructor
public class PlayerController {

    private final PlayerService playerService;
    @PostMapping("/all")
    public ResponseEntity<List<Player>> addPlayers(@RequestBody List<PlayerDto> players){
        return ResponseEntity.ok(playerService.addPlayers(players));
    }
}
