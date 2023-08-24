package com.kyu.hitgoplayerinfobackend.dao;

import com.kyu.hitgoplayerinfobackend.entity.match.ThirdYdkjMatch;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ThirdYdkjMatchRepository extends JpaRepository<ThirdYdkjMatch, Integer> {

    Optional<ThirdYdkjMatch> findByName(String name);
}
