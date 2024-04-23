package com.mizgmapr.project.classes;

import lombok.*;

import javax.persistence.*;
import java.io.File;

@EqualsAndHashCode
@ToString
@Entity
@Table(name = "Cat")
public class Cat {

    @Column(name = "hypoallergenic")
    boolean hypoallergenic;
    @Column(name = "aggressive")
    boolean aggressive;
    @Column(name = "fur")
    boolean fur;
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

    public Cat(String name, String race, double weight, boolean aggressive, String color, boolean fur, boolean hypoallergenic) {
        this.name = name;
        this.race = race;
        this.weight = weight;
        this.aggressive = aggressive;
        this.color = color;
        this.fur = fur;
        this.hypoallergenic = hypoallergenic;
    }
}