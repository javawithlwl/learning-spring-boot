package com.careerit.springbootbasics.controller;

import com.careerit.springbootbasics.domain.Player;
import com.careerit.springbootbasics.service.PlayerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/players")
public class PlayerController {

      private final PlayerService playerService;

      @GetMapping("/all")
      public ResponseEntity<List<Player>> getPlayers(){
          return ResponseEntity.ok(playerService.getPlayers());
      }

}
