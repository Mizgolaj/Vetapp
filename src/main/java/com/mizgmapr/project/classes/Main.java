package com.mizgmapr.project.classes;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Optional;

@SpringBootApplication
public class Main {

    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
        Database testDatabase = new Database();
        testDatabase.create();
    }

    public static Optional<String> readFile(String pathname) {
        FileInputStream input = null;
        try {
            input = new FileInputStream(pathname);
            StringBuilder stringBuilder = new StringBuilder();

            int i = input.read();
            while (i != -1) {
                stringBuilder.append((char) i);
                i = input.read();
            }

            input.close();
            return Optional.of(stringBuilder.toString());
        } catch (Exception ex) {
            try {
                if (input != null) {
                    input.close();
                }
            } catch (IOException ioEx) {
                System.out.println("Error while trying to read the file");
            }
            System.out.println("Reading failed: " + ex.getMessage());
        }
        return Optional.empty();
    }
}
