package com.mizgmapr.project.classes;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

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



	}
}
