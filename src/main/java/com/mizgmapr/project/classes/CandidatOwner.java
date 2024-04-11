package com.mizgmapr.project.classes;

public class CandidatOwner extends Client {
    double rating;
    private String address;

    public CandidatOwner(String name, String surname, double rating, String address) {
        super(name, surname);
        this.address = address;
        this.rating = rating;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
