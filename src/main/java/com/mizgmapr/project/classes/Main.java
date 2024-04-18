package com.mizgmapr.project.classes;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Optional;
import java.util.Set;

@SpringBootApplication
public class Main {

    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
        System.out.println("Hello");

        line("Candidate Owner = Starting test");
        CandidateOwner Maciej = new CandidateOwner("Maciej", "Kowalski", "ccc", 0.0);
        Maciej.ratingCalculator(2);
        System.out.println(Maciej);
        Maciej.ratingCalculator(4);
        Maciej.ratingCalculator(5);
        Maciej.ratingCalculator(5);
        System.out.println(Maciej);
        Maciej.ratingCalculator(5);
        System.out.println(Maciej.rating);
        System.out.println(Maciej.hashCode());
        line("Candidate Owner = Testing over");

        line("DataBase test - Creation");
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

            line("Testing instance creation of classess");

            Dog randomDog = new Dog("Reksio", "Dariusz Mazowiecki", "Border Colie", 22.5, false, false, "Fur", true, "Mixed");
            Cat randomCat = new Cat("Kicia", "Dariusz Mazowiecki", "Persian", 15.7, true, "Grey-Blue", true, false);
            Rodent randomRodent = new Rodent("Rat", "Grey", "Alfred", "Dariusz Mazowiecki", "Rex", 0.7, false);
            Other randomOther = new Other("Lizard", "Wacław", "Dariusz Mazowiecki", "Gecko", 0.4, true);
            Shelter randomShelter = new Shelter("Shelter", "ul.Akacjowa 4", "www.shelter.com", "07:00", "15:00", true);
            Owner randomOwner = new Owner("Dariusz", "Mazowiecki", Set.of("Reksio", "Kicia", "Wacław", "Alfred"), "ul. Piłsudskiego 5");
            Accomodation accomodation = new Accomodation("random accomodation", "Akacjowa 5", "www.randomAccomodation.com", "7", "15", Set.of("Dog", "Cat"), true);

            System.out.println(randomOwner);
            System.out.println(randomDog);
            System.out.println(randomCat);
            System.out.println(randomRodent);
            System.out.println(randomOther);
            System.out.println(randomShelter);
            System.out.println(accomodation);

            try (Session session = sessionFactory.openSession()) {
                session.getTransaction().begin();
                session.save(randomOwner);
                session.save(Maciej);
                session.save(randomDog);
                session.save(randomCat);
                session.save(randomRodent);
                session.save(randomOther);
                session.save(randomShelter);
                session.save(accomodation);
                session.getTransaction().commit();
            }
            line("DataBase Test over");
        }
    }

    public static Optional<String> readFile(String pathname) {
        FileInputStream input = null;
        try {
            input = new FileInputStream(pathname);
            StringBuilder stringBuilder = new StringBuilder();

            int i = input.read();
            while (i != -1) {
                stringBuilder.append((char) i);
                i = input.read();
            }

            input.close();
            return Optional.of(stringBuilder.toString());
        } catch (Exception ex) {
            try {
                if (input != null) {
                    input.close();
                }
            } catch (IOException ioEx) {
                System.out.println("Error while trying to read the file");
            }
            System.out.println("Reading failed: " + ex.getMessage());
        }
        return Optional.empty();
    }

    public static void line (String s){
        System.out.println("--------------------------------------------------------------------------------------------");
        System.out.println(s);
        System.out.println("--------------------------------------------------------------------------------------------");
    }
}
