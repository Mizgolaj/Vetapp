package com.mizgmapr.project.classes;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Main {

	public static void main(String[] args) {
		SpringApplication.run(Main.class, args);
		System.out.println("Hello");
		CandidatOwner Maciek = new CandidatOwner("Maciek", "Kowalski", "ccc");
		Maciek.ratingCalculator(4);
		Maciek.ratingCalculator(4);
		Maciek.ratingCalculator(5);
		Maciek.ratingCalculator(5);
		System.out.println(Maciek.rating);
		Maciek.ratingCalculator(5);
		System.out.println(Maciek.rating);

	}
}
