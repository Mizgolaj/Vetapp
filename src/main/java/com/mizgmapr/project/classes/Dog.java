package com.mizgmapr.project.classes;

import java.io.File;

public class Dog {
    boolean forAllergySufferers;
    boolean aggressive;
    boolean undercoat;
    String typeOfHair;
    String color;
    String name;
    String race;
    private String ownerData;
    private File treatmentRecords;
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
