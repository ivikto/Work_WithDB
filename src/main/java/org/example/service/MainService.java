package org.example.service;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.example.model.Bank;
import org.example.model.CarDealer;
import org.example.model.Person;
import org.example.repo.BankRepo;
import org.example.repo.CarDealerRepo;
import org.example.repo.CarRepo;
import org.example.repo.PersonRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class MainService {

    @Getter
    private final PersonRepo personRepo;
    @Getter
    private final BankRepo bankRepo;
    @Getter
    private final CarRepo carRepo;
    @Getter
    private final CarDealerRepo carDealerRepo;
    @Getter
    private final CarDealer carDealer;
    @Getter
    private final Bank bank;

    @Autowired
    public MainService(PersonRepo personRepo, BankRepo bankRepo, CarRepo carRepo, CarDealer carDealer, CarDealerRepo carDealerRepo, Bank bank) {
        this.personRepo = personRepo;
        this.bankRepo = bankRepo;
        this.carRepo = carRepo;
        this.carDealer = carDealer;
        this.carDealerRepo = carDealerRepo;
        this.bank = bank;

    }

    public void run () {
        log.info("Starting MainService - RUN");
        TablesLoad tablesLoad = new TablesLoad(this);
        tablesLoad.loadCars();
        tablesLoad.loadPersons();
        log.info("All Tables Loaded");
    }

}
