package com.mizgmapr.project.classes;

import lombok.EqualsAndHashCode;
import lombok.ToString;
import java.util.Set;
import javax.persistence.*;

@EqualsAndHashCode
@ToString
@Entity
@Table(name = "CateringPlace")
public class CateringPlace {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int ratingCounter;
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

    public CateringPlace(String name, String address, String website, String openHour, String closeHour, double rating, Set<String> acceptedPets) {
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
        } else {
            rating = ((rating * ratingCounter) + grade) / (ratingCounter + 1);
        }
        ratingCounter++;
    }
}