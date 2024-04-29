package com.mizgmapr.project.classes;

import lombok.*;

import javax.persistence.*;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

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
    @Column(name = "treatmentRecords")
    private File treatmentRecords;
    @Getter
    @Setter(AccessLevel.PROTECTED)
    @Column(name = "weight")
    private double weight;

    @ManyToMany(mappedBy = "dogs")
    private List<Dog> dogs = new ArrayList<>();

    @ManyToMany(mappedBy = "cats")
    private List<Cat> cats = new ArrayList<>();

    @ManyToMany(mappedBy = "rodents")
    private List<Rodent> rodents = new ArrayList<>();

    @ManyToMany(mappedBy = "others")
    private List<Other> others = new ArrayList<>();

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
