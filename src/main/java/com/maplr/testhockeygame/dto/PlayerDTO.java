package com.maplr.testhockeygame.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PlayerDTO {

    private long number;
    private String name;
    private String lastname;
    private String position;
    private Boolean isCaptain;

    public PlayerDTO(long number, String name, String lastname, String position, Boolean isCaptain) {
        this.number = number;
        this.name = name;
        this.lastname = lastname;
        this.position = position;
        this.isCaptain = isCaptain;
    }
}
