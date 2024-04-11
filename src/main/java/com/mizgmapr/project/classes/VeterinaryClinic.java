package com.mizgmapr.project.classes;

import java.util.List;

public class VeterinaryClinic extends Institution{
    double rating;
    private List<Owner> petsOwners;
    List<String> acceptedPets;
    public VeterinaryClinic(String name, String address, String website, String openHour, String closeHour, double rating, List<String> acceptedPets) {
        super(name, address, website, openHour, closeHour);
        this.rating = rating;
        this.acceptedPets = acceptedPets;
    }

    public List<Owner> getPetsOwners() {
        return petsOwners;
    }

    public void setPetsOwners(List<Owner> petsOwners) {
        this.petsOwners = petsOwners;
    }
}
