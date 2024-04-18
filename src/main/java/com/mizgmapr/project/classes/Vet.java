package com.mizgmapr.project.classes;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@EqualsAndHashCode
@ToString
@Entity
@Table(name = "Vet")
public class Vet {

    int ratingCounter;
    @Column(name = "ClinicName")
    String clinicName;
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

    public Vet(String name, String surname, String clinicName, double rating, String authorizationNumber) {
        this.name = name;
        this.surname = surname;
        this.clinicName = clinicName;
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
