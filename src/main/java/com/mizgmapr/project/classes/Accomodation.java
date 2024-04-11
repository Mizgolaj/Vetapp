package com.mizgmapr.project.classes;

import java.util.List;

public class Accomodation extends Institution{
    double rating;
    List<String> acceptedPets;
    boolean additionalFees;

    public Accomodation(String name, String address, String website, String openHour, String closeHour, double rating, List<String> acceptedPets, boolean additionalFees) {
        super(name, address, website, openHour, closeHour);
        this.rating = rating;
        this.acceptedPets = acceptedPets;
        this.additionalFees = additionalFees;
    }
}
