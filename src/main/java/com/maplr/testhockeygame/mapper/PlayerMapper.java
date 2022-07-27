package com.maplr.testhockeygame.mapper;

import com.maplr.testhockeygame.dto.PlayerDTO;
import com.maplr.testhockeygame.model.PlayerEntity;
import com.maplr.testhockeygame.model.TeamEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PlayerMapper {

    PlayerDTO playerEntityToPlayerDTO(PlayerEntity playerEntity, TeamEntity teamEntity);

    PlayerEntity playerDTOToPlayerEntity(PlayerDTO playerDTO);

}
