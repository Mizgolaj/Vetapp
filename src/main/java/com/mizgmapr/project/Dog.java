package com.mizgmapr.project;

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
    private int dog_id;
    @Getter
    @Setter(AccessLevel.PROTECTED)
    @Column(name = "treatmentRecords")
    private File treatmentRecords;
    @Getter
    @Setter(AccessLevel.PROTECTED)
    @Column(name = "weight")
    private double weight;

    public Dog(){};

    public Dog(String name, String race, double weight, boolean aggressive, String color, String typeOfHair, boolean forAllergySufferers, boolean undercoat) {
        this.name = name;
        this.race = race;
        this.weight = weight;
        this.aggressive = aggressive;
        this.color = color;
        this.typeOfHair = typeOfHair;
        this.forAllergySufferers = forAllergySufferers;
        this.undercoat = undercoat;
    }
}
