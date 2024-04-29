package com.mizgmapr.project.classes;

import lombok.*;

import java.util.List;
import java.util.Set;

import javax.persistence.*;

@EqualsAndHashCode
@ToString
@Entity
@Table(name = "VeterinaryClinic")
public class VeterinaryClinic {

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
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Getter
    @Setter(AccessLevel.PROTECTED)
    @Column(name = "petsOwners")
    @ElementCollection(targetClass=String.class)
    private Set<String> petsOwners;
    private int ratingCounter;

    @ManyToMany
    @JoinTable(
            name = "Vet",
            joinColumns = { @JoinColumn(name = "id") },
            inverseJoinColumns = { @JoinColumn(name = "id")})
    @Getter
    @Setter
    private List<Vet> Vet;

    public VeterinaryClinic(String name, String address, String website, String openHour, String closeHour, double rating, Set<String> acceptedPets) {
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
