package com.maplr.testhockeygame.mapper;

import com.maplr.testhockeygame.dto.TeamDTO;
import com.maplr.testhockeygame.model.TeamEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TeamMapper {

    TeamDTO teamEntityToTeamDTO(TeamEntity teamEntity);

}
