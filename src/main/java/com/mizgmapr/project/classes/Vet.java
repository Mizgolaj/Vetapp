package com.mizgmapr.project.classes;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
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
    @Getter
    @Setter
    private List<Dog> dogs;

    @ManyToMany
    @Getter
    @Setter
    private List<Cat> cats;

    @ManyToMany
    @Getter
    @Setter
    private List<Other> others;

    @ManyToMany
    @Getter
    @Setter
    private List<Rodent> rodents;

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
