package com.mizgmapr.project.classes;

import java.util.List;

public class Shelter extends Institution{
    List<Pet> avaliablePets;
    boolean walksAvaliable;

    public Shelter(String name, String address, String website, String openHour, String closeHour, List<Pet> avaliablePets, boolean walksAvaliable) {
        super(name, address, website, openHour, closeHour);
        this.avaliablePets = avaliablePets;
        this.walksAvaliable = walksAvaliable;
    }
}
