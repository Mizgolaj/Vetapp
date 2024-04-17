package com.mizgmapr.project.classes;

import lombok.*;

@ToString
@EqualsAndHashCode
public class CandidateOwner {

    double rating;
    int ratingCounter = 0;

    @Getter
    @Setter(AccessLevel.PROTECTED)
    private String name;
    @Getter
    @Setter(AccessLevel.PROTECTED)
    private String surname;
    @Getter
    @Setter(AccessLevel.PROTECTED)
    private String address;

    public CandidateOwner(String name, String surname, String address) {
        this.name = name;
        this.surname = surname;
        this.address = address;
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