package com.mizgmapr.project.service;

import com.mizgmapr.project.Accomodation;
import com.mizgmapr.project.repository.AccomodationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AccomodationService {
    @Autowired
    private AccomodationRepository accomodationRepository;

    public List<Accomodation> findAll(){
        return accomodationRepository.findAll();
    }

    public Optional<Accomodation> findById(int id){
        return accomodationRepository.findById(id);
    }
}
