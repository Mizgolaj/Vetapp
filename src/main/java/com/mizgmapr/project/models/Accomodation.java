package com.mizgmapr.project.models;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import javax.persistence.*;
import java.util.Set;

@EqualsAndHashCode
@ToString
@Entity
@Table(name = "Accomodation")
public class Accomodation {

    @Column(name = "name")
    @Getter
    String name;
    @Column(name = "address")
    @Getter
    String address;
    @Column(name = "website")
    @Getter
    String website;
    @Column(name = "openHour")
    @Getter
    String openHour;
    @Column(name = "closeHour")
    @Getter
    String closeHour;
    @Column(name = "rating")
    @Getter
    double rating;
    @Column(name = "acceptedPets")
    @ElementCollection(targetClass=String.class)
    @Getter
    Set<String> acceptedPets;
    @Column(name = "additionalFees")
    @Getter
    boolean additionalFees;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    private int id;
    @Getter
    private int ratingCounter;

    public Accomodation(String name, String address, String website, String openHour, String closeHour, double rating, Set<String> acceptedPets, boolean additionalFees) {
        this.name = name;
        this.address = address;
        this.website = website;
        this.openHour = openHour;
        this.closeHour = closeHour;
        this.acceptedPets = acceptedPets;
        this.rating = rating;
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
