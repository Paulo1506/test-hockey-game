package com.maplr.testhockeygame.mapper;

import com.maplr.testhockeygame.dto.PlayerDTO;
import com.maplr.testhockeygame.model.PlayerEntity;
import com.maplr.testhockeygame.model.TeamEntity;
import org.springframework.stereotype.Component;

@Component
public class PlayerMapperImpl implements PlayerMapper {

    @Override
    public PlayerDTO playerEntityToPlayerDTO(PlayerEntity playerEntity, TeamEntity teamEntity) {
        if (playerEntity == null) return null;

        PlayerEntity captain = teamEntity.getCaptain();

        return new PlayerDTO(playerEntity.getNumber(), playerEntity.getName(), playerEntity.getLastname(), playerEntity.getPosition(), captain.equals(playerEntity) ? true : null);
    }

    @Override
    public PlayerEntity playerDTOToPlayerEntity(PlayerDTO playerDTO) {
        if (playerDTO == null) return null;

        return new PlayerEntity(playerDTO.getNumber(), playerDTO.getName(), playerDTO.getLastname(), playerDTO.getPosition());
    }
}
