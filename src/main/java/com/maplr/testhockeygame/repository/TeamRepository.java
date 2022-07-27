package com.maplr.testhockeygame.repository;

import com.maplr.testhockeygame.model.TeamEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TeamRepository extends JpaRepository<TeamEntity, Long> {

    @Query("FROM TeamEntity t JOIN FETCH t.players WHERE t.year = (:year)")
    Optional<TeamEntity> findByYear(@Param("year") long year);
}
