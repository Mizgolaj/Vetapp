package com.mizgmapr.project.classes;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.File;

@SpringBootApplication
public class Main {

    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
        System.out.println("Hello");


        System.out.println("---------------Candidate Owner = Starting test -----------------");
        CandidateOwner Maciek = new CandidateOwner("Maciek", "Kowalski", "ccc",0.0);
        Maciek.ratingCalculator(2);
        System.out.println(Maciek);
        Maciek.ratingCalculator(4);
        Maciek.ratingCalculator(5);
        Maciek.ratingCalculator(5);
        System.out.println(Maciek);
        Maciek.ratingCalculator(5);
        System.out.println(Maciek.rating);
        System.out.println(Maciek.hashCode());
        System.out.println("---------------Candidate Owner = Testing over-----------------");

        System.out.println("-------------DataBase test - Creation of Owner--------------------");
        try (SessionFactory sessionFactory = new Configuration()
                .addAnnotatedClass(Owner.class)
                .addAnnotatedClass(CandidateOwner.class)
                .buildSessionFactory()) {

            Owner randomOwner = new Owner("Dariusz", "Mazowiecki", new File("repository/randomOwner_listOfPets.txt"), "ul. Piłsudskiego 5");
            System.out.println(randomOwner);
            try (Session session = sessionFactory.openSession()) {
                session.getTransaction().begin();
                session.save(randomOwner);
                session.save(Maciek);
                session.getTransaction().commit();
            }

            System.out.println("-------------DataBase test over--------------------");
        }
    }
}