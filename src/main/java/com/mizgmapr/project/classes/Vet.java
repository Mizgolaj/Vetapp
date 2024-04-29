package com.mizgmapr.project.classes;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@EqualsAndHashCode
@ToString
@Entity
@Table(name = "Vet")
public class Vet {

    int ratingCounter;
    @Column(name = "Rating")
    double rating;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Getter
    @Setter
    @Column(name = "Name")
    private String name;
    @Getter
    @Setter
    @Column(name = "Surname")
    private String surname;
    @Getter
    @Setter
    @Column(name = "AuthorizationNumber")
    private String authorizationNumber;

    @ManyToMany
    @JoinTable(
            name = "Dog",
            joinColumns = { @JoinColumn(name = "id") },
            inverseJoinColumns = { @JoinColumn(name = "id")})
    @Getter
    @Setter
    private List<Dog> dogs;

    @ManyToMany
    @JoinTable(
            name = "Cat",
            joinColumns = { @JoinColumn(name = "id") },
            inverseJoinColumns = { @JoinColumn(name = "id")})
    @Getter
    @Setter
    private List<Cat> cats;

    @ManyToMany
    @JoinTable(
            name = "Other",
            joinColumns = { @JoinColumn(name = "id") },
            inverseJoinColumns = { @JoinColumn(name = "id")})
    @Getter
    @Setter
    private List<Other> others;

    @ManyToMany
    @JoinTable(
            name = "Rodent",
            joinColumns = { @JoinColumn(name = "id") },
            inverseJoinColumns = { @JoinColumn(name = "id")})
    @Getter
    @Setter
    private List<Rodent> rodents;

    @ManyToMany(mappedBy = "Vet")
    private List<Vet> vets = new ArrayList<Vet>();

    public Vet(String name, String surname, double rating, String authorizationNumber) {
        this.name = name;
        this.surname = surname;
        this.rating = rating;
        this.authorizationNumber = authorizationNumber;
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
