package com.mizgmapr.project.classes;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Table;
import javax.persistence.Entity;

@EqualsAndHashCode
@ToString
@Entity
@Table(name = "Vet")
public class Vet {
    @Column(name = "ClinicName")
    String clinicName;
    @Column(name = "Rating")
    double rating;
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

    public Vet(String name, String surname, String clinicName, double rating, String authorizationNumber) {
        this.name = name;
        this.surname = surname;
        this.clinicName = clinicName;
        this.rating = rating;
        this.authorizationNumber = authorizationNumber;
    }
}
