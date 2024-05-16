package com.mizgmapr.project.repository;

import com.mizgmapr.project.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class AccomodationRepository {

    private final List<Accomodation> accomodations;


    public AccomodationRepository() {
        this.accomodations = buildFakeAccomodations();
    }

    private List<Accomodation> buildFakeAccomodations() {


        try (SessionFactory sessionFactory = new Configuration()
                .addAnnotatedClass(Accomodation.class)
                .buildSessionFactory()) {

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

            try (Session session = sessionFactory.openSession()) {
                session.getTransaction().begin();
                session.save(firstAccomodation);
                session.save(secondAccomodation);
                session.save(thirdAccomodation);

                session.getTransaction().commit();


            }
            return List.of(firstAccomodation, secondAccomodation, thirdAccomodation);

        }

    }


    public List<Accomodation> findAll() {
        return this.accomodations;


    }

    public Optional<Accomodation> findById(int id) {
        Optional<Accomodation> searchedAccId = Optional.empty();
        List<Accomodation> filteredAccomodations = this.accomodations.stream()
                .filter(p -> Objects.equals(p.getId(), id))
                .collect(Collectors.toList());
        if (!filteredAccomodations.isEmpty()) {
            searchedAccId = Optional.of(filteredAccomodations.get(0));
        }
        return searchedAccId;
    }

}
