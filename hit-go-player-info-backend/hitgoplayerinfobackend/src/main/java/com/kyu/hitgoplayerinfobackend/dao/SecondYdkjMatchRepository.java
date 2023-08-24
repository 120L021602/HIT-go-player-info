package com.kyu.hitgoplayerinfobackend.dao;

import com.kyu.hitgoplayerinfobackend.entity.match.SecondYdkjMatch;
import com.kyu.hitgoplayerinfobackend.entity.match.ThirdYdkjMatch;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SecondYdkjMatchRepository extends JpaRepository<SecondYdkjMatch, Integer> {

    Optional<SecondYdkjMatch> findByName(String name);
}
