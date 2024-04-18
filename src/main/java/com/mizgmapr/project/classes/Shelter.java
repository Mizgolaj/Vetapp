package com.mizgmapr.project.classes;

import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.*;
import java.io.File;
@EqualsAndHashCode
@ToString
@Entity
@Table(name = "Shelter")

public class Shelter{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "name")
    String name;
    @Column(name = "address")
    String address;
    @Column(name = "website")
    String website;
    @Column(name = "openHour")
    String openHour;
    @Column(name = "closeHour")
    String closeHour;
    @Column(name = "avaliablePets")
    File avaliablePets;
    @Column(name = "walksAvaliable")
    boolean walksAvaliable;

    public Shelter(String name, String address, String website, String openHour, String closeHour, boolean walksAvaliable) {
        this.name = name;
        this.address = address;
        this.website = website;
        this.openHour = openHour;
        this.closeHour = closeHour;
        this.walksAvaliable = walksAvaliable;
    }
}
