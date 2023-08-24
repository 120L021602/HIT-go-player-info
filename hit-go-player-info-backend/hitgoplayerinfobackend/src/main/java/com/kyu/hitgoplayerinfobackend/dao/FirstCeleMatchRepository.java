package com.kyu.hitgoplayerinfobackend.dao;

import com.kyu.hitgoplayerinfobackend.entity.match.FirstCeleMatch;
import com.kyu.hitgoplayerinfobackend.entity.player.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FirstCeleMatchRepository extends JpaRepository<FirstCeleMatch, Integer> {
}
