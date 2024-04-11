package com.mizgmapr.project.classes;

import java.io.File;

public class Rodent extends Pet {

    String typeOfRodent;
    String color;


    public Rodent(String name, String owner_data, String race, double weight, boolean aggressive, String typeOfRodent, String color) {
        super(name, owner_data, race, weight, aggressive);
        this.typeOfRodent = typeOfRodent;
        this.color = color;
    }
}
