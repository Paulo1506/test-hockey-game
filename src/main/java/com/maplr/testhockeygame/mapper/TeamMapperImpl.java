package com.maplr.testhockeygame.mapper;

import com.maplr.testhockeygame.dto.PlayerDTO;
import com.maplr.testhockeygame.dto.TeamDTO;
import com.maplr.testhockeygame.model.PlayerEntity;
import com.maplr.testhockeygame.model.TeamEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class TeamMapperImpl implements TeamMapper {

    @Autowired
    PlayerMapper playerMapper;


    @Override
    public TeamDTO teamEntityToTeamDTO(TeamEntity teamEntity) {
        if (teamEntity == null) {
            return null;
        }

        return new TeamDTO(teamEntity.getId(), teamEntity.getCoach(), teamEntity.getYear(), playerOfTeamDTO(teamEntity));
    }

    private List<PlayerDTO> playerOfTeamDTO(TeamEntity teamEntity) {
        List<PlayerEntity> players = teamEntity.getPlayers();
        return players.stream().map(player -> playerMapper.playerEntityToPlayerDTO(player, teamEntity)).collect(Collectors.toList());
    }
}
