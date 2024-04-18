package com.mizgmapr.project.classes;

import lombok.*;

import javax.persistence.*;
import java.io.File;

@EqualsAndHashCode
@ToString
@Entity
@Table(name = "Other")
public class Other{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "typeOfPet")
    String typeOfPet;
    @Column(name = "name")
    String name;
    @Getter
    @Setter(AccessLevel.PROTECTED)
    @Column(name = "ownerData")
    private String ownerData;
    @Getter
    @Setter(AccessLevel.PROTECTED)
    @Column(name = "treatmentRecords")
    private File treatmentRecords;
    @Column(name = "race")
    String race;
    @Getter
    @Setter(AccessLevel.PROTECTED)
    @Column(name = "weight")
    private double weight;
    @Column(name = "aggresive")
    boolean aggressive;

    public Other(String typeOfPet, String name, String ownerData, String race, double weight, boolean aggressive) {
        this.typeOfPet = typeOfPet;
        this.name = name;
        this.ownerData = ownerData;
        this.race = race;
        this.weight = weight;
        this.aggressive = aggressive;
    }
}
