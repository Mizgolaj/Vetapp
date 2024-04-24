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

    public Owner(String name, String surname, String address) {
        this.name = name;
        this.surname = surname;
        this.address = address;
    }
}