package com.mizgmapr.project;

import java.io.File;

public class Dog implements Pet {
    String name;
    private String owner_data;
    private File treatment_records;
    String race;
    private double weight;
    boolean aggressive;
    boolean for_allergy_sufferers;
    String type_of_hair;
    boolean undercoat;
    String color;

    public Dog(String name, String owner_data, String race, double weight, boolean aggressive) {
        this.name = name;
        this.owner_data = owner_data;
        this.race = race;
        this.weight = weight;
        this.aggressive = aggressive;
    }

    public String getOwner_data() {
        return owner_data;
    }

    public void setOwner_data(String owner_data) {
        this.owner_data = owner_data;
    }

    public File getTreatment_records() {
        return treatment_records;
    }

    public void setTreatment_records(File treatment_records) {
        this.treatment_records = treatment_records;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }
}
