package com.mizgmapr.project.classes;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@EqualsAndHashCode
@ToString
@Entity
@Table(name = "Vet")
public class Vet {

    int ratingCounter;
    @Column(name = "Rating")
    double rating;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int vet_id;
    @Getter
    @Setter
    @Column(name = "Name")
    private String name;
    @Getter
    @Setter
    @Column(name = "Surname")
    private String surname;
    @Getter
    @Setter
    @Column(name = "AuthorizationNumber")
    private String authorizationNumber;

    @ManyToMany(targetEntity = Dog.class, cascade = { CascadeType.ALL })
    @JoinTable(name = "Vet_Dog",
            joinColumns = { @JoinColumn(name = "id") },
            inverseJoinColumns = { @JoinColumn(name = "vet_id") })
    @Getter
    @Setter
    private List<Dog> dogs;

    @ManyToMany(targetEntity = Cat.class, cascade = { CascadeType.ALL })
    @JoinTable(name = "Vet_Cat",
            joinColumns = { @JoinColumn(name = "id") },
            inverseJoinColumns = { @JoinColumn(name = "vet_id") })
    @Getter
    @Setter
    private List<Cat> cats;

    @ManyToMany(targetEntity = Other.class, cascade = { CascadeType.ALL })
    @JoinTable(name = "Vet_Other",
            joinColumns = { @JoinColumn(name = "id") },
            inverseJoinColumns = { @JoinColumn(name = "vet_id") })
    @Getter
    @Setter
    private List<Other> others;

    @ManyToMany(targetEntity = Rodent.class, cascade = { CascadeType.ALL })
    @JoinTable(name = "Vet_Rodent",
            joinColumns = { @JoinColumn(name = "id") },
            inverseJoinColumns = { @JoinColumn(name = "vet_id") })
    @Getter
    @Setter
    private List<Rodent> rodents;

    public Vet(){};


    public Vet(String name, String surname, double rating, String authorizationNumber) {
        this.name = name;
        this.surname = surname;
        this.rating = rating;
        this.authorizationNumber = authorizationNumber;
    }

    public void ratingCalculator(double grade) {
        if (rating == 0) {
            rating = grade;
        } else {
            rating = ((rating * ratingCounter) + grade) / (ratingCounter + 1);
        }
        ratingCounter++;
    }
}
