package com.kyu.hitgoplayerinfobackend.entity.speciallist;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "speciallist")
public class SpecialList {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name")
    private String name;
}
