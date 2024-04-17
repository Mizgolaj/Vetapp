package com.mizgmapr.project.classes;

import lombok.*;

import javax.persistence.*;

@ToString
@EqualsAndHashCode
@Entity
@Table(name = "CandidateOwner")
public class CandidateOwner {

    int ratingCounter = 0;
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
    @Column(name = "Grade")
    double rating;

    public CandidateOwner(String name, String surname, String address, double rating) {
        this.name = name;
        this.surname = surname;
        this.address = address;
        this.rating = rating;
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