package com.mizgmapr.project;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

@Configuration
public class DesktopConfiguration {

    @Autowired
    private ApplicationContext appContext;

    @PostConstruct
    public void openTrayIcon() throws Exception {
        TrayIcon icon = new TrayIcon(new ImageIcon(this.getClass().getResource("/spring.png")).getImage());
        icon.setImageAutoSize(true);
        icon.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Exiting app ...");
                SystemTray.getSystemTray().remove(icon);
                SpringApplication.exit(appContext);
            }
        });
        SystemTray.getSystemTray().add(icon);
        icon.displayMessage("Spring Boot", "Application started", TrayIcon.MessageType.INFO);
    }
}
