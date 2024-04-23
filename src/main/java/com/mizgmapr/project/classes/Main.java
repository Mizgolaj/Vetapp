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

            line("Creation of Classess - Dog.class");

            Dog firstDog = new Dog("Reksio", "Border Colie", 22.5, false, "Mixed", "Fur", true, false);
            Dog secondDog = new Dog("Fafik", "Rottweiler", 55.6, true, "Black", "Fur", true, false);
            Dog thirdDog = new Dog("Mikser", "Border Colie", 18.5, false, "Mixed", "Fur", true, false);
            Dog fourthDog = new Dog("Mały", "Chihuahua", 1.5, true, "Mixed", "Short hair", true, false);
            Dog fifthDog = new Dog("Luzak", "Golden Retriever", 28.3, false, "Golden", "Fur", true, false);
            Dog sixthDog = new Dog("Korek", "Chihuahua", 2.0, false, "Mixed", "Short Hair", true, true);
            Dog seventhDog = new Dog("Breton", "Alaskan Malamute", 38.0, false, "Gray", "Fur", true, false);
            Dog eigthDog = new Dog("Buła", "English Bulldog", 18.6, false, "Ginger", "Short Hair", true, true);
            Dog ninthDog = new Dog("Fado", "Shih Tzu", 7.8, false, "Carmel", "Fur", true, false);
            Dog tenthDog = new Dog("Bolo", "German Shepherd", 37.9, true, "Black", "Long Hair", false, true);

            line("Dogs created");

            line("Creation of Classess - Cat.class");

            Cat firstCat = new Cat("Kicia", "Persian", 15.7, true, "Grey-Blue", true, false);
            Cat secondCat = new Cat("Kicia", "Persian", 15.7, true, "Grey-Blue", true, false);
            Cat thirdCat = new Cat("Kicia", "Persian", 15.7, true, "Grey-Blue", true, false);
            Cat fourthCat = new Cat("Kicia", "Persian", 15.7, true, "Grey-Blue", true, false);
            Cat fifthCat = new Cat("Kicia", "Persian", 15.7, true, "Grey-Blue", true, false);
            Cat sixthCat = new Cat("Kicia", "Persian", 15.7, true, "Grey-Blue", true, false);
            Cat seventhCat = new Cat("Kicia", "Persian", 15.7, true, "Grey-Blue", true, false);
            Cat eigthCat = new Cat("Kicia", "Persian", 15.7, true, "Grey-Blue", true, false);
            Cat ninthCat = new Cat("Kicia", "Persian", 15.7, true, "Grey-Blue", true, false);
            Cat tenthCat = new Cat("Kicia", "Persian", 15.7, true, "Grey-Blue", true, false);

            line("Cats created");

            Rodent randomRodent = new Rodent("Alfred", "Rex", 0.7, false, "Grey", "Rat");
            Other randomOther = new Other("Wacław", "Lizard", 0.4, true, "Gecko");

            Shelter randomShelter = new Shelter("Shelter", "ul.Akacjowa 4", "www.shelter.com", "07:00", "15:00", true);
            Owner randomOwner = new Owner("Dariusz", "Mazowiecki", "ul. Piłsudskiego 5", Set.of("Reksio", "Kicia", "Wacław", "Alfred"));
            Accomodation accomodation = new Accomodation("random accomodation", "Akacjowa 5", "www.randomAccomodation.com", "7", "15", 0.0, Set.of("Dog", "Cat"), true);

            try (Session session = sessionFactory.openSession()) {
                session.getTransaction().begin();

                session.save(firstDog);session.save(secondDog);session.save(thirdDog);session.save(fourthDog);session.save(fifthDog);
                session.save(sixthDog);session.save(seventhDog);session.save(eigthDog);session.save(ninthDog);session.save(tenthDog);

                session.save(firstCat);session.save(secondCat);session.save(thirdCat);session.save(fourthCat);session.save(fifthCat);
                session.save(sixthCat);session.save(seventhCat);session.save(eigthCat);session.save(ninthCat);session.save(tenthCat);

                session.save(randomOwner);
                session.save(Maciej);
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

    public static void line(String s) {
        System.out.println("--------------------------------------------------------------------------------------------");
        System.out.println(s);
        System.out.println("--------------------------------------------------------------------------------------------");
    }
}
