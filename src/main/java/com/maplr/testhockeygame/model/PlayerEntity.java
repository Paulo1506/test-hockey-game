package com.maplr.testhockeygame.model;

import lombok.*;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;


@Entity
@Table(name = "player")
@Getter
@Setter
@RequiredArgsConstructor
@AllArgsConstructor
public class PlayerEntity {

    @Id
    @Column(name = "number")
    private long number;
    @Column(name = "name")
    private String name;
    @Column(name = "lastname")
    private String lastname;
    @Column(name = "position")
    private String position;

    @ManyToMany
    @JoinTable(name = "team_player",
            joinColumns = @JoinColumn(name = "player_id"),
            inverseJoinColumns = @JoinColumn(name = "team_id"))
    private List<TeamEntity> teams;

    public PlayerEntity(long number, String name, String lastname, String position) {
        this.number = number;
        this.name = name;
        this.lastname = lastname;
        this.position = position;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PlayerEntity that = (PlayerEntity) o;
        return number == that.number && Objects.equals(name, that.name) && Objects.equals(lastname, that.lastname) && Objects.equals(position, that.position) && Objects.equals(teams, that.teams);
    }

    @Override
    public int hashCode() {
        return Objects.hash(number, name, lastname, position, teams);
    }

    @Override
    public String toString() {
        return "PlayerEntity{" +
                "number=" + number +
                ", name='" + name + '\'' +
                ", lastname='" + lastname + '\'' +
                ", position='" + position + '\'' +
                ", teams=" + teams +
                '}';
    }
}
