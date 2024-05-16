package com.mizgmapr.project;

import lombok.*;

import javax.persistence.*;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

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
    @Column(name = "treatmentRecords")
    private File treatmentRecords;
    @Getter
    @Setter(AccessLevel.PROTECTED)
    @Column(name = "weight")
    private double weight;

    public Rodent() {};

    public Rodent(String name, String race, double weight, boolean aggressive, String color, String typeOfRodent) {
        this.name = name;
        this.race = race;
        this.weight = weight;
        this.aggressive = aggressive;
        this.color = color;
        this.typeOfRodent = typeOfRodent;
    }
}
