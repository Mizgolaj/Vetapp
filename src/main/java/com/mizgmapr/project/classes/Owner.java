package com.mizgmapr.project.classes;

import java.util.List;

public class Owner extends Client{
    List<Object> ownedPets;
    private String address;

    public Owner(String name, String surname, List<Object> ownedPets, String address) {
        super(name, surname);
        this.ownedPets = ownedPets;
        this.address = address;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
