package com.mizgmapr.project.classes;

import lombok.Getter;

import java.io.File;

public class Cat {
    boolean hypoallergenic;
    boolean aggressive;
    boolean fur;
    String color;
    String name;
    String race;
    @Getter
    private String ownerData;
    @Getter
    private File treatmentRecords;
    @Getter
    private double weight;

    public Cat(String name, String owner_data, String race, double weight, boolean aggressive, String color, boolean fur, boolean hypoallergenic) {
        this.name = name;
        this.ownerData = owner_data;
        this.race = race;
        this.weight = weight;
        this.aggressive = aggressive;
        this.color = color;
        this.fur = fur;
        this.hypoallergenic = hypoallergenic;
    }

    public void setOwnerData(String ownerData) {
        this.ownerData = ownerData;
    }

    public void setTreatmentRecords(File treatmentRecords) {
        this.treatmentRecords = treatmentRecords;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }
}
