package com.kyu.hitgoplayerinfobackend.dao;

import com.kyu.hitgoplayerinfobackend.entity.speciallist.SpecialList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SpecialListRepository extends JpaRepository<SpecialList, Integer> {

    Optional<SpecialList> findByName(String name);
}
