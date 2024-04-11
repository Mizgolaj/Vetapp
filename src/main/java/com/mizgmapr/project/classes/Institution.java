package com.mizgmapr.project.classes;

public abstract class Institution {
    String name;
    String address;
    String website;
    String openHour;
    String closeHour;

    public Institution(String name, String address, String website, String openHour, String closeHour) {
        this.name = name;
        this.address = address;
        this.website = website;
        this.openHour = openHour;
        this.closeHour = closeHour;
    }
}
