package com.mizgmapr.project.classes;

import lombok.*;

import javax.persistence.*;
import java.io.File;

@EqualsAndHashCode
@ToString
@Entity
@Table(name = "Rodent")
public class Rodent {

    @Column(name = "typeOfRodent")
    String typeOfRodent;
    @Column(name = "color")
    String color;
    @Column(name = "name")
    String name;
    @Column(name = "race")
    String race;
    @Column(name = "aggressive")
    boolean aggressive;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Getter
    @Setter(AccessLevel.PROTECTED)
    @Column(name = "ownerData")
    private String ownerData;
    @Getter
    @Setter(AccessLevel.PROTECTED)
    @Column(name = "treatmentRecords")
    private File treatmentRecords;
    @Getter
    @Setter(AccessLevel.PROTECTED)
    @Column(name = "weight")
    private double weight;

    public Rodent(String typeOfRodent, String color, String name, String ownerData, String race, double weight, boolean aggressive) {
        this.typeOfRodent = typeOfRodent;
        this.color = color;
        this.name = name;
        this.ownerData = ownerData;
        this.race = race;
        this.weight = weight;
        this.aggressive = aggressive;
    }
}
