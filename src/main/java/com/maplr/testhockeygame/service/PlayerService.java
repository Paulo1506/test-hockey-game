package com.maplr.testhockeygame.service;

import com.maplr.testhockeygame.dto.PlayerDTO;
import com.maplr.testhockeygame.mapper.PlayerMapper;
import com.maplr.testhockeygame.model.PlayerEntity;
import com.maplr.testhockeygame.model.TeamEntity;
import com.maplr.testhockeygame.repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PlayerService {
    private final TeamRepository teamRepository;
    @Autowired
    private PlayerMapper playerMapper;

    public PlayerService(TeamRepository teamRepository) {
        this.teamRepository = teamRepository;
    }

    public PlayerDTO updatePlayerInCaptain(long number, long year) {
        Optional<TeamEntity> team = teamRepository.findByYear(year);
        if (team.isEmpty()) {
            throw new IllegalArgumentException("Impossible to update player " + number + ". No team has been found for this year : " + year);
        }

        Optional<PlayerEntity> newCaptain = team.get()
                .getPlayers()
                .stream()
                .filter(player -> player.getNumber() == number)
                .findAny();

        if (newCaptain.isEmpty()) {
            throw new IllegalArgumentException("No player has this number" + number + " in the team.");
        }

        team.get().setCaptain(newCaptain.get());
        teamRepository.save(team.get());
        return playerMapper.playerEntityToPlayerDTO(newCaptain.get(), team.get());
    }

}
