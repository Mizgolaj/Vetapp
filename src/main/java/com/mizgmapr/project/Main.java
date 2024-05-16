package com.mizgmapr.project;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

import java.awt.*;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Optional;

@SpringBootApplication
public class Main {
    public static void main(String[] args) throws IOException {
        new SpringApplicationBuilder(Main.class).headless(false).run(args);
        Database testDatabase = new Database();
        testDatabase.create();
    }
    @EventListener(ApplicationReadyEvent.class)
    public static void openBrowserAfterStartup() throws IOException, URISyntaxException {
        Desktop.getDesktop().browse(new URI("http://localhost:8080"));
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
