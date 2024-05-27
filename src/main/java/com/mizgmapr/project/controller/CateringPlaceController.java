package com.mizgmapr.project.controller;

import com.mizgmapr.project.models.CateringPlace;
import com.mizgmapr.project.service.CateringPlaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/cateringPlaces")
public class CateringPlaceController {
    @Autowired
    private CateringPlaceService cateringPlaceService;

    @GetMapping(produces = "application/json")
    public ResponseEntity<List<CateringPlace>> findAll(){
        List<CateringPlace> allCateringPlaces = cateringPlaceService.findAll();
        return new ResponseEntity<>(allCateringPlaces, HttpStatus.OK);
    }

    @GetMapping (path="/{id}", produces = "application/json")
    public ResponseEntity<CateringPlace> findById(@PathVariable("id") int id){
        Optional<CateringPlace> cateringPlace = cateringPlaceService.findById(id);
        return cateringPlace.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
}
