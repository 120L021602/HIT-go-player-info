package com.kyu.hitgoplayerinfobackend.dao;

import com.kyu.hitgoplayerinfobackend.entity.match.FirstYdkjMatch;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FirstYdkjMatchRepository extends JpaRepository<FirstYdkjMatch, Integer> {
}
