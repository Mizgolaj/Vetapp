package com.mizgmapr.project.models;

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
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    private int id;
    @Getter
    @Setter(AccessLevel.PROTECTED)
    @Column(name = "petsOwners")
    @ElementCollection(targetClass=String.class)
    private Set<String> petsOwners;
    @Getter
    private int ratingCounter;

    @ManyToMany(targetEntity = Vet.class, cascade = { CascadeType.ALL })
    @JoinTable(name = "Vet_VeterinaryClinic",
            joinColumns = { @JoinColumn(name = "vet_id") },
            inverseJoinColumns = { @JoinColumn(name = "id") })
    @Getter
    @Setter
    private List<Vet> vets;


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
