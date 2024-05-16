package com.mizgmapr.project;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;
import java.util.Set;

import javax.persistence.*;

@EqualsAndHashCode
@ToString
@Entity
@Table(name = "Shelter")

public class Shelter {
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
    @Column(name = "availablePets")
    @ElementCollection(targetClass=String.class)
    Set<String> availablePets;
    @Column(name = "walksAvaliable")
    boolean walksAvaliable;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @OneToMany
    @Getter
    @Setter
    private List<Dog> dogs;

    @OneToMany
    @Getter
    @Setter
    private List<Cat> cats;

    @OneToMany
    @Getter
    @Setter
    private List<Other> others;

    @OneToMany
    @Getter
    @Setter
    private List<Rodent> rodents;

    public Shelter() {};

    public Shelter(String name, String address, String website, String openHour, String closeHour, boolean walksAvaliable) {
        this.name = name;
        this.address = address;
        this.website = website;
        this.openHour = openHour;
        this.closeHour = closeHour;
        this.walksAvaliable = walksAvaliable;
    }
}
