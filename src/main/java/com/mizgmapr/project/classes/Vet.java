package com.mizgmapr.project.classes;

public class Vet {
    String clinicName;
    double rating;
    private String name;
    private String surname;
    private String authorizationNumber;

    public Vet(String name, String surname, String clinicName, double rating, String authorizationNumber) {
        this.name = name;
        this.surname = surname;
        this.clinicName = clinicName;
        this.rating = rating;
        this.authorizationNumber = authorizationNumber;
    }

    public String getAuthorizationNumber() {
        return authorizationNumber;
    }

    public void setAuthorizationNumber(String authorizationNumber) {
        this.authorizationNumber = authorizationNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }
}
