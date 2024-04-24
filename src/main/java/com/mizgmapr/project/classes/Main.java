package com.mizgmapr.project.classes;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@SpringBootApplication
public class Main {

    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
        System.out.println("Hello");

        line("DataBase - Creation");
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

            Cat firstCat = new Cat("Kicia", "Persian", 5.7, true, "Grey-Blue", true, false);
            Cat secondCat = new Cat("Felek", "British Shorthair", 5.7, false, "Grey", true, false);
            Cat thirdCat = new Cat("Koteł", "Cornish Rex", 4.3, false, "Black-White", true, false);
            Cat fourthCat = new Cat("Karmazyn", "Norwegian Forest Cat", 8.2, true, "White-Orange", true, false);
            Cat fifthCat = new Cat("Książe", "Sphynx", 3.9, false, "Skin color", false, false);
            Cat sixthCat = new Cat("Mopik", "American Shorthair", 3.9, true, "Grey-Black", true, false);
            Cat seventhCat = new Cat("Nela", "Persian", 12.3, true, "Golden", true, false);
            Cat eigthCat = new Cat("Norman", "British Shorthair", 4.0, false, "Ginger", true, false);
            Cat ninthCat = new Cat("Rompar", "Devon Rex", 3.1, true, "Black", true, false);
            Cat tenthCat = new Cat("Stacy", "Cornish Rex", 3.9, true, "White", true, false);

            line("Cats created");

            line("Creation of Classess - Rodent.class");

            Rodent firstRodent = new Rodent("Alfred", "Rex", 0.7, false, "Grey", "Rat");
            Rodent secondRodent = new Rodent("Alfred", "Rex", 0.7, false, "Grey", "Rat");
            Rodent thirdRodent = new Rodent("Alfred", "Rex", 0.7, false, "Grey", "Rat");
            Rodent fourthRodent = new Rodent("Alfred", "Rex", 0.7, false, "Grey", "Rat");
            Rodent fifthRodent = new Rodent("Alfred", "Rex", 0.7, false, "Grey", "Rat");
            Rodent sixthRodent = new Rodent("Alfred", "Rex", 0.7, false, "Grey", "Rat");
            Rodent seventhRodent = new Rodent("Alfred", "Rex", 0.7, false, "Grey", "Rat");
            Rodent eigthRodent = new Rodent("Alfred", "Rex", 0.7, false, "Grey", "Rat");
            Rodent ninthRodent = new Rodent("Alfred", "Rex", 0.7, false, "Grey", "Rat");
            Rodent tenthRodent = new Rodent("Alfred", "Rex", 0.7, false, "Grey", "Rat");

            line("Rodents created");

            line("Creation of Classess - Other.class");

            Other firstOther = new Other("Wacław", "Lizard", 0.4, true, "Gecko");
            Other secondOther = new Other("Wacław", "Lizard", 0.4, true, "Gecko");
            Other thirdOther = new Other("Wacław", "Lizard", 0.4, true, "Gecko");
            Other fourthOther = new Other("Wacław", "Lizard", 0.4, true, "Gecko");
            Other fifthOther = new Other("Wacław", "Lizard", 0.4, true, "Gecko");
            Other sixthOther = new Other("Wacław", "Lizard", 0.4, true, "Gecko");
            Other seventhOther = new Other("Wacław", "Lizard", 0.4, true, "Gecko");
            Other eigthOther = new Other("Wacław", "Lizard", 0.4, true, "Gecko");
            Other ninthOther = new Other("Wacław", "Lizard", 0.4, true, "Gecko");
            Other tenthOther = new Other("Wacław", "Lizard", 0.4, true, "Gecko");

            line("Others created");

            line("Creation of Classess - CandidateOwner.class");

            CandidateOwner firstCandidateOwner = new CandidateOwner("Maciej", "Kowalski", "ul. Nieziemska 5", 0.0);
            firstCandidateOwner.ratingCalculator(2);firstCandidateOwner.ratingCalculator(4);
            firstCandidateOwner.ratingCalculator(5);firstCandidateOwner.ratingCalculator(5);
            firstCandidateOwner.setDogs(List.of(firstDog,ninthDog));

            CandidateOwner secondCandidateOwner = new CandidateOwner("Kornelia", "Równomierna", "ul. Zawady 23/3", 0.0);
            secondCandidateOwner.ratingCalculator(3);secondCandidateOwner.ratingCalculator(1);
            secondCandidateOwner.ratingCalculator(6);secondCandidateOwner.ratingCalculator(6);
            secondCandidateOwner.setCats(List.of(fourthCat,seventhCat,tenthCat));

            CandidateOwner thirdCandidateOwner = new CandidateOwner("Zdzisław", "Sobieracki", "ul. Wodna 3", 0.0);
            thirdCandidateOwner.ratingCalculator(2);thirdCandidateOwner.ratingCalculator(2);
            thirdCandidateOwner.ratingCalculator(1);thirdCandidateOwner.ratingCalculator(5);
            thirdCandidateOwner.setRodents(List.of(firstRodent, sixthRodent));

            line("Candidate Owners created");

            line("Creation of Classess - Owner.class");

            Owner firstOwner = new Owner("Dariusz", "Mazowiecki", "ul. Piłsudskiego 5");
            firstOwner.setDogs(List.of(secondDog));
            firstOwner.setCats(List.of(thirdCat));

            Owner secondOwner = new Owner("Miron", "Wielkoduszny", "ul. Polna 36");
            secondOwner.setRodents(List.of(secondRodent, ninthRodent));
            secondOwner.setOthers(List.of(firstOther, sixthOther));

            Owner thirdOwner = new Owner("Kamila", "Pardonowa", "ul. Kijanki 23/4");
            thirdCandidateOwner.setCats(List.of(firstCat, secondCat));

            line("Owners created");

            Shelter randomShelter = new Shelter("Shelter", "ul.Akacjowa 4", "www.shelter.com", "07:00", "15:00", true);
            Accomodation accomodation = new Accomodation("random accomodation", "Akacjowa 5", "www.randomAccomodation.com", "7", "15", 0.0, Set.of("Dog", "Cat"), true);

            try (Session session = sessionFactory.openSession()) {
                session.getTransaction().begin();

                session.save(firstDog);session.save(secondDog);session.save(thirdDog);session.save(fourthDog);session.save(fifthDog);
                session.save(sixthDog);session.save(seventhDog);session.save(eigthDog);session.save(ninthDog);session.save(tenthDog);

                session.save(firstCat);session.save(secondCat);session.save(thirdCat);session.save(fourthCat);session.save(fifthCat);
                session.save(sixthCat);session.save(seventhCat);session.save(eigthCat);session.save(ninthCat);session.save(tenthCat);

                session.save(firstRodent);session.save(secondRodent);session.save(thirdRodent);session.save(fourthRodent);session.save(fifthRodent);
                session.save(sixthRodent);session.save(seventhRodent);session.save(eigthRodent);session.save(ninthRodent);session.save(tenthRodent);

                session.save(firstOther);session.save(secondOther);session.save(thirdOther);session.save(fourthOther);session.save(fifthOther);
                session.save(sixthOther);session.save(seventhOther);session.save(eigthOther);session.save(ninthOther);session.save(tenthOther);

                session.save(firstCandidateOwner);session.save(secondCandidateOwner);session.save(thirdCandidateOwner);

                session.save(firstOwner);session.save(secondOwner);session.save(thirdOwner);

                session.save(randomShelter);
                session.save(accomodation);

                session.getTransaction().commit();
            }
            line("DataBase creation over");
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
