package com.mizgmapr.project.repository;

import com.mizgmapr.project.Accomodation;
import com.mizgmapr.project.CateringPlace;
import com.mizgmapr.project.VeterinaryClinic;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class CateringPlaceRepository {

    private final List<CateringPlace> cateringPlaces;


    public CateringPlaceRepository() {
        this.cateringPlaces = buildFakeAccomodations();
    }

    private List<CateringPlace> buildFakeAccomodations() {


        try (SessionFactory sessionFactory = new Configuration()
                .addAnnotatedClass(CateringPlace.class)
                .buildSessionFactory()) {

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
                session.save(firstCateringPlace);
                session.save(secondCateringPlace);

                session.getTransaction().commit();


            }
            return List.of(firstCateringPlace, secondCateringPlace);

        }

    }


    public List<CateringPlace> findAll() {
        return this.cateringPlaces;


    }

    public Optional<CateringPlace> findById(int id) {
        Optional<CateringPlace> searchedCPid = Optional.empty();
        List<CateringPlace> filteredCateringPlaces = this.cateringPlaces.stream()
                .filter(p -> Objects.equals(p.getId(), id))
                .collect(Collectors.toList());
        if (!filteredCateringPlaces.isEmpty()) {
            searchedCPid = Optional.of(filteredCateringPlaces.get(0));
        }
        return searchedCPid;
    }
}
