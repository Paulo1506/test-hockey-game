package com.maplr.testhockeygame.service;

import com.maplr.testhockeygame.dto.PlayerDTO;
import com.maplr.testhockeygame.dto.TeamDTO;
import com.maplr.testhockeygame.mapper.PlayerMapper;
import com.maplr.testhockeygame.mapper.TeamMapper;
import com.maplr.testhockeygame.model.PlayerEntity;
import com.maplr.testhockeygame.model.TeamEntity;
import com.maplr.testhockeygame.repository.PlayerRepository;
import com.maplr.testhockeygame.repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TeamService {

    private final TeamRepository teamRepository;
    private final PlayerRepository playerRepository;
    @Autowired
    private TeamMapper teamMapper;
    @Autowired
    private PlayerMapper playermapper;

    public TeamService(TeamRepository teamRepository, PlayerRepository playerRepository) {
        this.teamRepository = teamRepository;
        this.playerRepository = playerRepository;

    }

    public TeamDTO findTeamByYear(long year) {
        Optional<TeamEntity> team = teamRepository.findByYear(year);
        if (team.isPresent()) {
            return teamMapper.teamEntityToTeamDTO(team.get());
        }

        throw new IllegalArgumentException("No team has been found for this year : " + year);
    }

    public PlayerDTO addPlayer(long year, PlayerDTO player) {

        Optional<TeamEntity> team = teamRepository.findByYear(year);
        if (team.isPresent()) {
            PlayerEntity newPlayer = playermapper.playerDTOToPlayerEntity(player);
            team.get().getPlayers().add(newPlayer);

            playerRepository.save(newPlayer);

            return playermapper.playerEntityToPlayerDTO(newPlayer, team.get());
        }

        throw new IllegalArgumentException("Impossible to add player " + player.getNumber() + ". No team has been found for this year : " + year);
    }
}
