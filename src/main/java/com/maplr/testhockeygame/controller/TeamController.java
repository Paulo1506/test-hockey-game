package com.maplr.testhockeygame.controller;

import com.maplr.testhockeygame.dto.PlayerDTO;
import com.maplr.testhockeygame.dto.TeamDTO;
import com.maplr.testhockeygame.service.TeamService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@RequestMapping("/api/team")
public class TeamController {

    private final TeamService teamService;

    public TeamController(TeamService teamService) {
        this.teamService = teamService;
    }

    @GetMapping(value = "/{year}")
    public ResponseEntity<TeamDTO> findTeamByYear(@PathVariable(value = "year") long year) {
        return ResponseEntity.ok(teamService.findTeamByYear(year));
    }

    @PostMapping(value = "/{year}")
    public ResponseEntity<PlayerDTO> addPlayer(@PathVariable long year, @RequestBody PlayerDTO newPlayer) {
        return ResponseEntity.created(URI.create("api/team/" + year + "/newPlayer/" + newPlayer.getNumber())).body(teamService.addPlayer(year, newPlayer));
    }
}
