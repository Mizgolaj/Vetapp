package com.mizgmapr.project.classes;

import java.io.File;

public class Other extends Pet{
    String typeOfPet;
    String name;
    private String ownerData;
    private File treatmentRecords;
    String race;
    private double weight;
    boolean aggressive;


    public Other(String name, String owner_data, String race, double weight, boolean aggressive, String typeOfPet) {
        super(name, owner_data, race, weight, aggressive);
        this.typeOfPet = typeOfPet;
        System.out.println("Created");
    }
}
