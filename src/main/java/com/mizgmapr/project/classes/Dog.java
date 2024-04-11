package com.mizgmapr.project.classes;

import java.io.File;

public class Dog extends Pet {

    boolean forAllergySufferers;
    String typeOfHair;
    boolean undercoat;
    String color;


    public Dog(String name, String owner_data, String race, double weight, boolean aggressive, boolean forAllergySufferers, String typeOfHair, boolean undercoat, String color) {
        super(name, owner_data, race, weight, aggressive);
        this.forAllergySufferers = forAllergySufferers;
        this.typeOfHair = typeOfHair;
        this.undercoat = undercoat;
        this.color = color;
    }
}
