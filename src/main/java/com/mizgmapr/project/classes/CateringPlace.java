package com.mizgmapr.project.classes;

import java.util.List;

public class CateringPlace extends Institution{
    double rating;
    List<String> acceptedPets;

    public CateringPlace(String name, String address, String website, String openHour, String closeHour, double rating, List<String> acceptedPets) {
        super(name, address, website, openHour, closeHour);
        this.rating = rating;
        this.acceptedPets = acceptedPets;
    }
}
