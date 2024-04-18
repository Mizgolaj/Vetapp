package com.mizgmapr.project.classes;

import lombok.*;

import javax.persistence.*;
import java.io.File;

@EqualsAndHashCode
@ToString
@Entity
@Table(name = "VeterynaryClinic")

public class VeterinaryClinic{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "name")
    String name;
    @Column(name = "address")
    String address;
    @Column(name = "website")
    String website;
    @Column(name = "openHour")
    String openHour;
    @Column(name = "closeHour")
    String closeHour;
    @Column(name = "rating")
    double rating;
    @Getter
    @Setter(AccessLevel.PROTECTED)
    @Column(name = "petsOwners")
    private File petsOwners;
    @Column(name = "acceptedPets")
    File acceptedPets;
    private int ratingCounter;

    public VeterinaryClinic(String name, String address, String website, String openHour, String closeHour, double rating, File acceptedPets) {
        this.name = name;
        this.address = address;
        this.website = website;
        this.openHour = openHour;
        this.closeHour = closeHour;
        this.rating = rating;
        this.acceptedPets = acceptedPets;
    }

    public void ratingCalculator(double grade) {
        if (rating == 0) {
            rating = grade;
            ratingCounter++;
        } else {
            rating = ((rating * ratingCounter) + grade) / (ratingCounter + 1);
            ratingCounter++;
        }
    }
}
