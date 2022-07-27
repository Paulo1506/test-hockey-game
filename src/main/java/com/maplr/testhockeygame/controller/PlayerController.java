package com.maplr.testhockeygame.controller;

import com.maplr.testhockeygame.dto.PlayerDTO;
import com.maplr.testhockeygame.service.PlayerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/player")
public class PlayerController {

    private final PlayerService playerService;

    public PlayerController(PlayerService playerService) {
        this.playerService = playerService;
    }

    //Added "year" argument to define the year of the team in which the captain will be updated
    @PutMapping("/captain/{number}/{year}")
    public ResponseEntity<PlayerDTO> updateCaptain(@PathVariable(value = "number") long number, @PathVariable(value = "year") long year) {
        return ResponseEntity.ok(playerService.updatePlayerInCaptain(number, year));
    }
}
