package com.mizgmapr.project.classes;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;
import java.util.Set;

public class Database {
    public void create () {

        try (SessionFactory sessionFactory = new Configuration()
                .addAnnotatedClass(Vet.class)
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


            line("Creation of Classes - Dog.class");

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

            line("Creation of Classes - Cat.class");

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

            line("Creation of Classes - Rodent.class");

            Rodent firstRodent = new Rodent("Alfred", "Rex", 0.7, false, "Grey", "Rat");
            Rodent secondRodent = new Rodent("Mały", "Lanigera", 0.65, false, "Blue-Grey", "Chinchilla");
            Rodent thirdRodent = new Rodent("Brutus", "Longhaired", 0.46, false, "Orange-White", "Guinea Pig");
            Rodent fourthRodent = new Rodent("Kefir", "Winter White Dwarf", 0.23, false, "White", "Hamster");
            Rodent fifthRodent = new Rodent("Lampik", "Fuzzy", 0.14, false, "Brown", "Mice");
            Rodent sixthRodent = new Rodent("Czesir", "Astrex", 0.09, false, "Black-White", "Mice");
            Rodent seventhRodent = new Rodent("Chloe", "Shorthaired", 0.9, false, "Ginger", "Guinea Pig");
            Rodent eigthRodent = new Rodent("Ciastek", "Satin", 0.55, false, "Black", "Rat");
            Rodent ninthRodent = new Rodent("Dirk", "Common", 0.46, false, "Brown", "Degu");
            Rodent tenthRodent = new Rodent("Drow", "Honey", 0.24, false, "Golden", "Hamster");

            line("Creation of Classes - Other.class");

            Other firstOther = new Other("Emil", "Gecko", 0.4, false, "Reptile");
            Other secondOther = new Other("Frastek", "Wolf Spider", 0.7, true, "Spider");
            Other thirdOther = new Other("Śmieszek", "Algae Eater", 0.1, false, "Fish");
            Other fourthOther = new Other("Satyr", "Sea Horse", 0.1, false, "Fish");
            Other fifthOther = new Other("Krasnal", "Frog", 0.2, false, "Amphibian");
            Other sixthOther = new Other("Kolec", "Lizard", 0.1, true, "Amphibian");
            Other seventhOther = new Other("Wrotek", "Turtle", 2.1, false, "Reptile");
            Other eigthOther = new Other("Zygfryd", "Peacock's Eye", 0.1, false, "Fish");
            Other ninthOther = new Other("Doktorek", "Vietnamese Walking Stick", 0.1, false, "Insect");
            Other tenthOther = new Other("Lump", "Scorpion", 0.6, true, "Insect");

            line("Creation of Classes - CandidateOwner.class");

            CandidateOwner firstCandidateOwner = new CandidateOwner("Maciej", "Kowalski", "ul. Nieziemska 5", 0.0);
            firstCandidateOwner.ratingCalculator(2);
            firstCandidateOwner.ratingCalculator(4);
            firstCandidateOwner.ratingCalculator(5);
            firstCandidateOwner.ratingCalculator(5);
            firstCandidateOwner.setDogs(List.of(firstDog, ninthDog));

            CandidateOwner secondCandidateOwner = new CandidateOwner("Kornelia", "Równomierna", "ul. Zawady 23/3", 0.0);
            secondCandidateOwner.ratingCalculator(3);
            secondCandidateOwner.ratingCalculator(1);
            secondCandidateOwner.ratingCalculator(6);
            secondCandidateOwner.ratingCalculator(6);
            secondCandidateOwner.setCats(List.of(fourthCat, seventhCat, tenthCat));

            CandidateOwner thirdCandidateOwner = new CandidateOwner("Zdzisław", "Sobieracki", "ul. Wodna 3", 0.0);
            thirdCandidateOwner.ratingCalculator(2);
            thirdCandidateOwner.ratingCalculator(2);
            thirdCandidateOwner.ratingCalculator(1);
            thirdCandidateOwner.ratingCalculator(5);
            thirdCandidateOwner.setRodents(List.of(firstRodent, sixthRodent));

            line("Creation of Classes - Owner.class");

            Owner firstOwner = new Owner("Dariusz", "Mazowiecki", "ul. Piłsudskiego 5");
            firstOwner.setDogs(List.of(secondDog));
            firstOwner.setCats(List.of(thirdCat));

            Owner secondOwner = new Owner("Miron", "Wielkoduszny", "ul. Polna 36");
            secondOwner.setRodents(List.of(secondRodent, ninthRodent));
            secondOwner.setOthers(List.of(firstOther, sixthOther));

            Owner thirdOwner = new Owner("Kamila", "Pardonowa", "ul. Kijanki 23/4");
            thirdCandidateOwner.setCats(List.of(firstCat, secondCat));

            line("Creation of Classes - Vet.class");

            Vet firstVet = new Vet("Przemysław", "Dobrodziejski", 0.0, "5698642231");
            firstVet.ratingCalculator(5);
            firstVet.ratingCalculator(3);
            firstVet.ratingCalculator(5);
            firstVet.ratingCalculator(4);
            firstVet.setDogs(List.of(firstDog, secondDog, thirdDog, fourthDog, fifthDog, ninthDog));
            firstVet.setOthers(List.of(thirdOther, fourthOther, fifthOther, sixthOther, seventhOther));

            Vet secondVet = new Vet("Karolina", "Suwalska", 0.0, "7235648516");
            secondVet.ratingCalculator(1);
            firstVet.ratingCalculator(5);
            secondVet.ratingCalculator(6);
            firstVet.ratingCalculator(3);
            secondVet.setCats(List.of(firstCat, secondCat, thirdCat, fourthCat, fifthCat, sixthCat, seventhCat, eigthCat, ninthCat, tenthCat));

            Vet thirdVet = new Vet("Zbigniew", "Ukryty", 0.0, "2364851679");
            thirdVet.ratingCalculator(5);
            thirdVet.ratingCalculator(6);
            thirdVet.ratingCalculator(5);
            thirdVet.ratingCalculator(5);
            thirdVet.setRodents(List.of(firstRodent, secondRodent, thirdRodent, fourthRodent, fifthRodent, sixthRodent, seventhRodent, eigthRodent, ninthRodent, tenthRodent));
            thirdVet.setOthers(List.of(firstOther, secondOther, eigthOther, ninthOther, tenthOther));
            thirdVet.setDogs(List.of(sixthDog, seventhDog, eigthDog, tenthDog));

            line("Creation of Classes - VeterinaryClinic");

            VeterinaryClinic firstVeterinaryClinic = new VeterinaryClinic("AnimalCenter", "ul.Pomocna 24", "www.animalcenter.com", "07:00", "15:00", 0.0, Set.of("Cat", "Rodent"));
            firstVeterinaryClinic.ratingCalculator(3);
            firstVeterinaryClinic.ratingCalculator(6);
            firstVeterinaryClinic.ratingCalculator(5);
            firstVeterinaryClinic.ratingCalculator(6);
            firstVeterinaryClinic.ratingCalculator(3);
            firstVeterinaryClinic.ratingCalculator(6);
            firstVeterinaryClinic.setVets(List.of(secondVet, thirdVet));

            VeterinaryClinic secondVeterinaryClinic = new VeterinaryClinic("AnimalCare", "ul.Staszica 56/4", "www.animalcare-staszica.com", "07:00", "19:00", 0.0, Set.of("Dog", "Other"));
            secondVeterinaryClinic.ratingCalculator(2);
            secondVeterinaryClinic.ratingCalculator(6);
            secondVeterinaryClinic.ratingCalculator(3);
            secondVeterinaryClinic.ratingCalculator(4);
            secondVeterinaryClinic.ratingCalculator(3);
            secondVeterinaryClinic.ratingCalculator(5);
            secondVeterinaryClinic.setVets(List.of(firstVet, thirdVet));

            line("Creation of Classes - Shelter");

            Shelter firstShelter = new Shelter("Azorek", "ul.Kwiatowa 14", "www.azorek.pl", "07:00", "15:00", true);
            firstShelter.setDogs(List.of(firstDog, thirdDog, fourthDog, fifthDog, sixthDog, seventhDog, eigthDog));

            Shelter secondShelter = new Shelter("KiciaPrzystań", "ul.Dębowa 31", "www.kicia-przystan.com.pl", "07:00", "18:00", false);
            secondShelter.setCats(List.of(fourthCat, fifthCat, sixthCat, seventhCat, eigthCat, ninthCat));

            Shelter thirdShelter = new Shelter("Sklep Zoologiczny", "ul. Morska 24", "www.sklepzoo.pl", "06:00", "16:00", false);
            thirdShelter.setRodents(List.of(firstRodent, thirdRodent, fourthRodent, fifthRodent, sixthRodent, seventhRodent, eigthRodent, tenthRodent));
            thirdShelter.setOthers(List.of(secondOther, thirdOther, fourthOther, fifthOther, seventhOther, eigthOther, ninthOther, tenthOther));

            line("Creation of Classess - Accomodation");

            Accomodation firstAccomodation = new Accomodation("Playfull-site", "ul. Ognista 2", "www.playfull-site.com", "07:00", "22:00", 0.0, Set.of("Dog", "Cat"), true);
            firstAccomodation.ratingCalculator(3);
            firstAccomodation.ratingCalculator(2);
            firstAccomodation.ratingCalculator(5);
            firstAccomodation.ratingCalculator(4);

            Accomodation secondAccomodation = new Accomodation("Zoo-addicted", "ul. Kolejarzy 1", "www.zoo-addiction.com", "07:00", "22:00", 0.0, Set.of("Dog", "Cat", "Rodent", "Others"), true);
            secondAccomodation.ratingCalculator(6);
            secondAccomodation.ratingCalculator(4);
            secondAccomodation.ratingCalculator(5);
            secondAccomodation.ratingCalculator(6);

            Accomodation thirdAccomodation = new Accomodation("OnlyDogs", "ul. Piaskowa 65/4", "www.dogz.com", "06:00", "22:00", 0.0, Set.of("Dog"), false);
            thirdAccomodation.ratingCalculator(6);
            thirdAccomodation.ratingCalculator(6);
            thirdAccomodation.ratingCalculator(5);
            thirdAccomodation.ratingCalculator(6);

            line("Creation of Classess - Catering Place");

            CateringPlace firstCateringPlace = new CateringPlace("Zoo-Delicious", "ul. Zwierzęca 1", "www.delicious.com.pl", "07:00", "20:00", 0.0, Set.of("Dog", "Cat"));
            firstCateringPlace.ratingCalculator(1);
            firstCateringPlace.ratingCalculator(4);
            firstCateringPlace.ratingCalculator(3);
            firstCateringPlace.ratingCalculator(6);

            CateringPlace secondCateringPlace = new CateringPlace("Cat's Place", "ul. Żwirowa 33", "www.catzzz.com", "08:00", "15:00", 0.0, Set.of("Cat"));
            secondCateringPlace.ratingCalculator(6);
            secondCateringPlace.ratingCalculator(2);
            secondCateringPlace.ratingCalculator(5);
            secondCateringPlace.ratingCalculator(6);

            try (Session session = sessionFactory.openSession()) {
                session.getTransaction().begin();

                session.save(firstDog);
                session.save(secondDog);
                session.save(thirdDog);
                session.save(fourthDog);
                session.save(fifthDog);
                session.save(sixthDog);
                session.save(seventhDog);
                session.save(eigthDog);
                session.save(ninthDog);
                session.save(tenthDog);

                session.save(firstCat);
                session.save(secondCat);
                session.save(thirdCat);
                session.save(fourthCat);
                session.save(fifthCat);
                session.save(sixthCat);
                session.save(seventhCat);
                session.save(eigthCat);
                session.save(ninthCat);
                session.save(tenthCat);

                session.save(firstRodent);
                session.save(secondRodent);
                session.save(thirdRodent);
                session.save(fourthRodent);
                session.save(fifthRodent);
                session.save(sixthRodent);
                session.save(seventhRodent);
                session.save(eigthRodent);
                session.save(ninthRodent);
                session.save(tenthRodent);

                session.save(firstOther);
                session.save(secondOther);
                session.save(thirdOther);
                session.save(fourthOther);
                session.save(fifthOther);
                session.save(sixthOther);
                session.save(seventhOther);
                session.save(eigthOther);
                session.save(ninthOther);
                session.save(tenthOther);

                session.save(firstCandidateOwner);
                session.save(secondCandidateOwner);
                session.save(thirdCandidateOwner);

                session.save(firstOwner);
                session.save(secondOwner);
                session.save(thirdOwner);

                session.save(firstVet);
                session.save(secondVet);
                session.save(thirdVet);

                session.save(firstVeterinaryClinic);
                session.save(secondVeterinaryClinic);

                session.save(firstShelter);
                session.save(secondShelter);
                session.save(thirdShelter);

                session.save(firstAccomodation);
                session.save(secondAccomodation);
                session.save(thirdAccomodation);

                session.save(firstCateringPlace);
                session.save(secondCateringPlace);

                session.getTransaction().commit();
            }
            line("DataBase creation over");

            QueryManager.showAllDogs(sessionFactory);
            QueryManager.showHeavyDogs(sessionFactory);
            QueryManager.showLightDogs(sessionFactory);
            QueryManager.showAllCats(sessionFactory);
            QueryManager.showAllRodents(sessionFactory);
            QueryManager.showAllOtherAnimals(sessionFactory);
            QueryManager.showAllShelters(sessionFactory);
            QueryManager.showAllVeterinaryClinic(sessionFactory);



        }
    }

    public static void line(String s) {
        System.out.println("--------------------------------------------------------------------------------------------");
        System.out.println(s);
        System.out.println("--------------------------------------------------------------------------------------------");
    }
}