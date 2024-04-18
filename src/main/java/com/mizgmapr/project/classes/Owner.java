package com.mizgmapr.project.classes;

import lombok.*;
import java.util.Set;

import javax.persistence.*;


@EqualsAndHashCode
@ToString
@Entity
@Table(name = "Owner")
public class Owner {

    @Column(name = "OwnedPets")
    @ElementCollection(targetClass=String.class)
    Set<String> listOfOwnedPets;
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

    public Owner(String name, String surname, Set<String> listOfOwnedPets, String address) {
        this.name = name;
        this.surname = surname;
        this.listOfOwnedPets = listOfOwnedPets;
        this.address = address;
    }
}