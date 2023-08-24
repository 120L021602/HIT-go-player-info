package com.kyu.hitgoplayerinfobackend.entity.match;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "firstYdkjMatch")
public class FirstYdkjMatch {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
}
