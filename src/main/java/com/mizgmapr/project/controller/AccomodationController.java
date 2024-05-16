package com.mizgmapr.project.controller;

import com.mizgmapr.project.Accomodation;
import com.mizgmapr.project.service.AccomodationService;
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
@RequestMapping("/accomodations")
public class AccomodationController {
    @Autowired
    private AccomodationService accomodationService;

    @GetMapping(produces = "application/json")
    public ResponseEntity<List<Accomodation>> findAll(){
        List<Accomodation> allAccomodations = accomodationService.findAll();
        return new ResponseEntity<>(allAccomodations, HttpStatus.OK);
    }

    @GetMapping (path="/{id}", produces = "application/json")
    public ResponseEntity<Accomodation> findById(@PathVariable("id") int id){
        Optional<Accomodation> accomodation = accomodationService.findById(id);
        return accomodation.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

}
