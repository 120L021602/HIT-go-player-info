package com.kyu.hitgoplayerinfobackend.entity.match;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "firstCeleMatch")
public class FirstCeleMatch {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
}
