package com.mizgmapr.project.classes;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@EqualsAndHashCode
@ToString
@Entity
@Table(name = "Owner")
public class Owner {
    @Column(name = "OwnedPets")
    List<Object> ownedPets;
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

    public Owner(String name, String surname, List<Object> ownedPets, String address) {
        this.name = name;
        this.surname = surname;
        this.ownedPets = ownedPets;
        this.address = address;
    }
}