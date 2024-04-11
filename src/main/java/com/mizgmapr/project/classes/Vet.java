package com.mizgmapr.project.classes;

public class Vet extends Client{
    String clinicName;
    double rating;
    private String authorizationNumber;
    public Vet(String name, String surname, String clinicName, double rating, String authorizationNumber) {
        super(name, surname);
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
}
