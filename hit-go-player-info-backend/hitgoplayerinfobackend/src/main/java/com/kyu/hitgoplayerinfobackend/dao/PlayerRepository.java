package com.kyu.hitgoplayerinfobackend.dao;

import com.kyu.hitgoplayerinfobackend.entity.player.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
public interface PlayerRepository extends JpaRepository<Player, Integer> {
    @Modifying
    @Transactional
    void deleteByNameAndNativePlace(String name, String nativePlace);

    Optional<Player> findByName(String name);

    List<Player> findAllByName(String name);
    Optional<Player> findByNameAndGenderAndYearOfBirth(String name, String gender, String yearOfBirth);
}
