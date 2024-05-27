package com.mizgmapr.project.service;

import com.mizgmapr.project.models.CateringPlace;
import com.mizgmapr.project.repository.CateringPlaceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CateringPlaceService {
    @Autowired
    private CateringPlaceRepository cateringPlaceRepository;

    public List<CateringPlace> findAll(){
        return cateringPlaceRepository.findAll();
    }

    public Optional<CateringPlace> findById(int id){
        return cateringPlaceRepository.findById(id);
    }
}
