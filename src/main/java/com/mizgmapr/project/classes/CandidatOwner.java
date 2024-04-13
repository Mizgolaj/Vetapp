package com.mizgmapr.project.classes;

public class CandidatOwner extends Client {
    double rating;
    int ratingCounter = 0;
    private String address;

    public CandidatOwner(String name, String surname, String address) {
        super(name, surname);
        this.address = address;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void ratingCalculator(double grade) {
        if(rating == 0){
            rating = grade;
            ratingCounter++;
        } else {
            rating = ((rating * ratingCounter) + grade) / (ratingCounter + 1);
            ratingCounter++;
        }
    }
}
