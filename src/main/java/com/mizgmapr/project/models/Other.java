package com.mizgmapr.project.models;

import lombok.*;

import javax.persistence.*;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

@EqualsAndHashCode
@ToString
@Entity
@Table(name = "Other")
public class Other {

    @Column(name = "typeOfPet")
    String typeOfPet;
    @Column(name = "name")
    String name;
    @Column(name = "race")
    String race;
    @Column(name = "aggresive")
    boolean aggressive;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Getter
    @Setter(AccessLevel.PROTECTED)
    @Column(name = "treatmentRecords")
    private File treatmentRecords;
    @Getter
    @Setter(AccessLevel.PROTECTED)
    @Column(name = "weight")
    private double weight;

    public Other() {};

    public Other(String name, String race, double weight, boolean aggressive, String typeOfPet) {
        this.name = name;
        this.race = race;
        this.weight = weight;
        this.aggressive = aggressive;
        this.typeOfPet = typeOfPet;
    }
}
