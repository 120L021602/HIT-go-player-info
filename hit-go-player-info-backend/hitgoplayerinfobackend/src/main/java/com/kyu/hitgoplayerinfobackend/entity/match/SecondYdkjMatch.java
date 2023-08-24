package com.kyu.hitgoplayerinfobackend.entity.match;

import lombok.Data;

import javax.persistence.*;

//2022寒假“云度科技杯”棋王争霸赛
@Data
@Entity
@Table(name = "secondYdkjMatch")
public class SecondYdkjMatch {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "ranking")
    private String ranking;
}
