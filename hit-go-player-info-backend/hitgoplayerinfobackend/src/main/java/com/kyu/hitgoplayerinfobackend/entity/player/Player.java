package com.kyu.hitgoplayerinfobackend.entity.player;

import lombok.Data;

import javax.persistence.*;
@Data
@Entity
@Table(name = "player")
public class Player {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "gender")
    private String gender;

    @Column(name = "yearOfBirth")
    private String yearOfBirth;

    @Column(name = "school")
    private String school;

    @Column(name = "department")
    private String department;

    @Column(name = "major")
    private String major;

    @Column(name = "level")
    private String level;

    @Column(name = "nativePlace")
    private String nativePlace;

    @Column(name = "yhAccount")
    private String yhAccount;

    @Column(name = "comment")
    private String comment;
}
