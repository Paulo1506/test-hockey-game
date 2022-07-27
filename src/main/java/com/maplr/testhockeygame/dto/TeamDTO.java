package com.maplr.testhockeygame.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class TeamDTO {

    private long id;
    private String coach;
    private long year;
    private List<PlayerDTO> players;

    public TeamDTO(long id, String coach, long year, List<PlayerDTO> players) {
        this.id = id;
        this.coach = coach;
        this.year = year;
        this.players = players;
    }
}
