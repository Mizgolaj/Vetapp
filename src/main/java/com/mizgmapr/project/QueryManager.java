package com.mizgmapr.project;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

public class QueryManager {

    private final SessionFactory sessionFactory;

    public QueryManager(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public static void showAllDogs(SessionFactory sessionFactory) {
        try (Session session = sessionFactory.openSession()) {
            Query<Dog> query = session.createQuery("FROM Dog", Dog.class);
            System.out.printf("All dogs registred in database: %s%n", query.list());
        }
    }

    public static void showAggressiveDogs(SessionFactory sessionFactory) {
        try (Session session = sessionFactory.openSession()) {
            Query<Dog> query = session.createQuery("SELECT name FROM Dog WHERE aggressive = true");
            System.out.printf("Aggressive dogs registred in database: %s%n", query.list());
        }
    }

    public static void showNonAggressiveDogs(SessionFactory sessionFactory) {
        try (Session session = sessionFactory.openSession()) {
            Query<Dog> query = session.createQuery("SELECT name FROM Dog WHERE aggressive = false");
            System.out.printf("Not aggressive dogs registred in database: %s%n", query.list());
        }
    }

    public static void showDogsForAllergySufferer(SessionFactory sessionFactory) {
        try (Session session = sessionFactory.openSession()) {
            Query<Dog> query = session.createQuery("SELECT name FROM Dog WHERE forAllergySufferers = true");
            System.out.printf("Dogs for allergy sufferers registred in database: %s%n", query.list());
        }
    }

    public static void showHeavyDogs(SessionFactory sessionFactory) {
        try (Session session = sessionFactory.openSession()) {
            Query<Dog> query = session.createQuery("SELECT name FROM Dog WHERE weight > 20");
            System.out.printf("Dogs with mass over 20 kilos: %s%n", query.list());
        }
    }

    public static void showLightDogs(SessionFactory sessionFactory) {
        try (Session session = sessionFactory.openSession()) {
            Query<Dog> query = session.createQuery("SELECT name FROM Dog WHERE weight <= 20");
            System.out.printf("Dogs with mass under 20 kilos: %s%n", query.list());
        }
    }

    public static void showAllCats(SessionFactory sessionFactory) {
        try (Session session = sessionFactory.openSession()) {
            Query<Cat> query = session.createQuery("FROM Cat", Cat.class);
            System.out.printf("All Cats registred in database: %s%n", query.list());
        }
    }

    public static void showAllRodents(SessionFactory sessionFactory) {
        try (Session session = sessionFactory.openSession()) {
            Query<Rodent> query = session.createQuery("FROM Rodent", Rodent.class);
            System.out.printf("All Rodents registred in database: %s%n", query.list());
        }
    }

    public static void showAllOtherAnimals(SessionFactory sessionFactory) {
        try (Session session = sessionFactory.openSession()) {
            Query<Other> query = session.createQuery("FROM Other", Other.class);
            System.out.printf("All Other Animals registred in database: %s%n", query.list());
        }
    }

    public static void showTypesOfOtherAnimals(SessionFactory sessionFactory) {
        try (Session session = sessionFactory.openSession()) {
            Query<Other> query = session.createQuery("SELECT DISTINCT typeOfPet FROM Other");
            System.out.printf("Type of pets registred in database: %s%n", query.list());
        }
    }

    public static void showAllShelterNames(SessionFactory sessionFactory) {
        try (Session session = sessionFactory.openSession()) {
            Query<Shelter> query = session.createQuery("SELECT name FROM Shelter");
            System.out.printf("All Shelter's names registred in database: %s%n", query.list());
        }
    }

    public static void showAllSheltersWithWalksAvaliable(SessionFactory sessionFactory) {
        try (Session session = sessionFactory.openSession()) {
            Query<Shelter> query = session.createQuery("SELECT s.name FROM Shelter s WHERE WalksAvaliable = true");
            System.out.printf("All Shelter's with walks avaliable registred in database: %s%n", query.list());

        }

    }


    public static void showAllVeterinaryClinicNames(SessionFactory sessionFactory) {
        try (Session session = sessionFactory.openSession()) {
            Query<VeterinaryClinic> query = session.createQuery("SELECT name FROM VeterinaryClinic");
            System.out.printf("All Veterinary Clinic's names registred in database: %s%n", query.list());
        }
    }


}
