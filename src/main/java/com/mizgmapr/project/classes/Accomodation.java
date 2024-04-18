package com.mizgmapr.project.classes;

import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.*;
import java.util.Set;

@EqualsAndHashCode
@ToString
@Entity
@Table(name = "Accomodation")
public class Accomodation {

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
    @Column(name = "acceptedPets")
    @ElementCollection(targetClass=String.class)
    Set<String> acceptedPets;
    @Column(name = "additionalFees")
    boolean additionalFees;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int ratingCounter;

    public Accomodation(String name, String address, String website, String openHour, String closeHour, Set<String> acceptedPets, boolean additionalFees) {
        this.name = name;
        this.address = address;
        this.website = website;
        this.openHour = openHour;
        this.closeHour = closeHour;
        this.acceptedPets = acceptedPets;
        this.additionalFees = additionalFees;
    }

    public void ratingCalculator(double grade) {
        if (rating == 0) {
            rating = grade;
        } else {
            rating = ((rating * ratingCounter) + grade) / (ratingCounter + 1);
        }
        ratingCounter++;
    }
}
