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
                .addAnnotatedClass(Dog.class)
                .addAnnotatedClass(Cat.class)
                .addAnnotatedClass(Rodent.class)
                .addAnnotatedClass(Other.class)
                .addAnnotatedClass(Shelter.class)
                .addAnnotatedClass(Accomodation.class)
                .addAnnotatedClass(CateringPlace.class)
                .addAnnotatedClass(VeterinaryClinic.class)
                .buildSessionFactory()) {

            Dog randomDog = new Dog("Reksio", "Dariusz Mazowiecki", "Border Colie", 22.5, false, false, "fur", true, "mixed");

            Owner randomOwner = new Owner("Dariusz", "Mazowiecki", new File("repository/randomOwner_listOfPets.txt"), "ul. Piłsudskiego 5");

            Cat randomCat = new Cat("Kicia", "Dariusz Mazowiecki", "Persian cat", 15.7, true, "grey-blue", true, false);

            Rodent randomRodent = new Rodent("rat", "grey", "Alfred", "Dariusz Mazowiecki", "--", 0.7, false );

            Other randomOther = new Other("lizard", "Waclaw", "Dariusz Mazowiecki", "Gekon", 0.4, true);

            Shelter randomShelter = new Shelter("shelter", "Akacjowa 4", "www.shelter.com", "7", "15", true);

            //Accomodation accomodation = new Accomodation("random accomodation", "Akacjowa 5", "www.randomAccomodation.com", "7", "15", "src/main/resources/randomAccomodation", true);

            System.out.println(randomOwner);
            System.out.println(randomDog);
            System.out.println(randomCat);
            System.out.println(randomRodent);
            System.out.println(randomOther);
            System.out.println(randomShelter);

            try (Session session = sessionFactory.openSession()) {
                session.getTransaction().begin();
                session.save(randomOwner);
                session.save(Maciek);
                session.save(randomDog);
                session.save(randomCat);
                session.save(randomRodent);
                session.save(randomOther);
                session.save(randomShelter);
                session.getTransaction().commit();
            }

            System.out.println("-------------DataBase test over--------------------");
        }


    }
}