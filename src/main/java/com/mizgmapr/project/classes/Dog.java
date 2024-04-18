package com.mizgmapr.project.classes;

import lombok.*;

import javax.persistence.*;
import java.io.File;

@EqualsAndHashCode
@ToString
@Entity
@Table(name = "Dog")
public class Dog {
    @Column(name = "forAllergySufferers")
    boolean forAllergySufferers;
    @Column(name = "aggressive")
    boolean aggressive;
    @Column(name = "undercoat")
    boolean undercoat;
    @Column(name = "typeOfHair")
    String typeOfHair;
    @Column(name = "color")
    String color;
    @Column(name = "name")
    String name;
    @Column(name = "race")
    String race;
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


    public Dog(String name, String owner_data, String race, double weight, boolean aggressive, boolean forAllergySufferers, String typeOfHair, boolean undercoat, String color) {
        this.name = name;
        this.ownerData = owner_data;
        this.race = race;
        this.weight = weight;
        this.aggressive = aggressive;
        this.forAllergySufferers = forAllergySufferers;
        this.typeOfHair = typeOfHair;
        this.undercoat = undercoat;
        this.color = color;
    }
}
