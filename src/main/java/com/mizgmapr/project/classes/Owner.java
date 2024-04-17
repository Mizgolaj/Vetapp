package com.mizgmapr.project.classes;

import lombok.*;

import javax.persistence.*;
import java.io.File;

@EqualsAndHashCode
@ToString
@Entity
@Table(name = "Owner")
public class Owner {
    @Column(name = "OwnedPets")
    File listOfOwnedPets;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Getter
    @Setter(AccessLevel.PROTECTED)
    @Column(name = "Address")
    private String address;

    @Getter
    @Setter(AccessLevel.PROTECTED)
    @Column(name = "Name")
    private String name;

    @Getter
    @Setter(AccessLevel.PROTECTED)
    @Column(name = "Surname")
    private String surname;

    public Owner(String name, String surname, File listOfOwnedPets, String address) {
        this.name = name;
        this.surname = surname;
        this.listOfOwnedPets = listOfOwnedPets;
        this.address = address;
    }
}