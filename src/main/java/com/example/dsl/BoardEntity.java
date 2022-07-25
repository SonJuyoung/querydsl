package com.example.dsl;

import lombok.Getter;

import javax.persistence.*;

@Entity
@Table(name = "board")
@Getter
public class BoardEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String title;

    private String ctnt;
}
