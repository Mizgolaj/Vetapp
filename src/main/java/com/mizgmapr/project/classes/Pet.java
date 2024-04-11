package com.mizgmapr.project.classes;

import java.io.File;

public abstract class Pet {
    String name;
    private String ownerData;
    private File treatmentRecords;
    String race;
    private double weight;
    boolean aggressive;

    public Pet(String name, String owner_data, String race, double weight, boolean aggressive) {
        this.name = name;
        this.ownerData = owner_data;
        this.race = race;
        this.weight = weight;
        this.aggressive = aggressive;
    }

    public String getOwner_data() {
        return ownerData;
    }

    public void setOwner_data(String owner_data) {
        this.ownerData = owner_data;
    }

    public File getTreatment_records() {
        return treatmentRecords;
    }

    public void setTreatment_records(File treatment_records) {
        this.treatmentRecords = treatment_records;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }
}
