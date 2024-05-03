package com.mizgmapr.project.classes;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import java.util.List;
import java.util.stream.Collectors;

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

    public static void showHeavyDogs(SessionFactory sessionFactory) {
        try (Session session = sessionFactory.openSession()) {
            Query<Dog> query = session.createQuery("FROM Dog WHERE weight > 20", Dog.class);
            System.out.printf("Dogs with mass over 20 kilos: %s%n", query.list());
        }
    }

    public static void showLightDogs(SessionFactory sessionFactory) {
        try (Session session = sessionFactory.openSession()) {
            Query<Dog> query = session.createQuery("FROM Dog WHERE weight <= 20", Dog.class);
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

    public static void showAllShelters(SessionFactory sessionFactory) {
        try (Session session = sessionFactory.openSession()) {
            Query<Shelter> query = session.createQuery("FROM Shelter", Shelter.class);
            System.out.printf("All Shelters registred in database: %s%n", query.list());
        }
    }


    public static void showAllVeterinaryClinic(SessionFactory sessionFactory) {
        try (Session session = sessionFactory.openSession()) {
            Query<VeterinaryClinic> query = session.createQuery("FROM VeterinaryClinic", VeterinaryClinic.class);
            System.out.printf("All Veterinary Clinics registred in database: %s%n", query.list());
        }
    }


}
