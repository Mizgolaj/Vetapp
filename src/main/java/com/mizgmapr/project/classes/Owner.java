package com.mizgmapr.project.classes;

import lombok.*;

import javax.persistence.*;
import java.util.List;
import java.util.Set;


@EqualsAndHashCode
@ToString
@Entity
@Table(name = "Owner")
public class Owner {

    @Column(name = "OwnedPets")
    @ElementCollection(targetClass = String.class)
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

    @OneToMany
    private List<Dog> dogs;

    @OneToMany
    private List<Cat> cats;

    @OneToMany
    private List<Other> others;

    @OneToMany
    private List<Rodent> rodents;

    public Owner(String name, String surname, String address, Set<String> listOfOwnedPets) {
        this.name = name;
        this.surname = surname;
        this.address = address;
        this.listOfOwnedPets = listOfOwnedPets;
    }
}