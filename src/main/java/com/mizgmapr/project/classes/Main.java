package com.mizgmapr.project.classes;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@SpringBootApplication
public class Main {

	public static void main(String[] args) {
		SpringApplication.run(Main.class, args);
		System.out.println("Hello");



		System.out.println("---------------Candidate Owner = Starting test -----------------");
		CandidateOwner Maciek = new CandidateOwner("Maciek", "Kowalski", "ccc");
		Maciek.ratingCalculator(4);
		Maciek.ratingCalculator(4);
		Maciek.ratingCalculator(5);
		Maciek.ratingCalculator(5);
		System.out.println(Maciek);
		Maciek.ratingCalculator(5);
		System.out.println(Maciek.rating);
		System.out.println(Maciek.hashCode());
		System.out.println("---------------Candidate Owner = Testing over-----------------");

		System.out.println("-------------table test--------------------");

		System.out.println("-------------test over--------------------");
	}

	



}
