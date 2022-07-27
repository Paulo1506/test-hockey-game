package com.maplr.testhockeygame.model;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "team")
@Getter
@Setter
@RequiredArgsConstructor
@AllArgsConstructor
public class TeamEntity implements Serializable {

    @Id
    @Column(name = "id")
    private long id;

    @Column(name = "coach")
    private String coach;

    @Column(name = "year", unique = true)
    private long year;

    @ManyToMany
    @JoinTable(
            name = "team_player",
            joinColumns = @JoinColumn(name = "team_id"),
            inverseJoinColumns = @JoinColumn(name = "player_id"))
    private List<PlayerEntity> players;

    @OneToOne
    @JoinColumn(name = "captain")
    private PlayerEntity captain;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TeamEntity that = (TeamEntity) o;
        return id == that.id && year == that.year && Objects.equals(coach, that.coach) && Objects.equals(players, that.players) && Objects.equals(captain, that.captain);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, coach, year, players, captain);
    }

    @Override
    public String toString() {
        return "TeamEntity{" +
                "id=" + id +
                ", coach='" + coach + '\'' +
                ", year=" + year +
                ", players=" + players +
                ", captain=" + captain +
                '}';
    }
}
