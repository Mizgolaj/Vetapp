package com.mizgmapr.project.classes;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@ToString
@EqualsAndHashCode
@Entity
@Table(name = "CandidateOwner")
public class CandidateOwner {

    int ratingCounter = 0;
    @Column(name = "Grade")
    double rating;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Getter
    @Setter(AccessLevel.PROTECTED)
    @Column(name = "Name")
    private String name;
    @Getter
    @Setter(AccessLevel.PROTECTED)
    @Column(name = "Surname")
    private String surname;
    @Getter
    @Setter(AccessLevel.PROTECTED)
    @Column(name = "Address")
    private String address;

    @OneToMany
    @Getter
    @Setter
    private List<Dog> dogs;

    @OneToMany
    @Getter
    @Setter
    private List<Cat> cats;

    @OneToMany
    @Getter
    @Setter
    private List<Other> others;

    @OneToMany
    @Getter
    @Setter
    private List<Rodent> rodents;

    public CandidateOwner(String name, String surname, String address, double rating) {
        this.name = name;
        this.surname = surname;
        this.address = address;
        this.rating = rating;
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