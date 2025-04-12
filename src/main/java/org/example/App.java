package org.example;

import org.example.service.MainService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class App implements CommandLineRunner {


    private final MainService mainService;

    public App(MainService mainService) {
        this.mainService = mainService;
    }


    public static void main(String[] args) {
        SpringApplication.run(App.class, args);

    }

    @Override
    public void run(String... args) {
        mainService.run();
    }
}