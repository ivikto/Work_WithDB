package org.example.service;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.example.model.BankAccount;
import org.example.model.CarDealer;
import org.example.repo.BankAccountRepo;
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
    private final BankAccountRepo bankAccountRepo;
    @Getter
    private final CarRepo carRepo;
    @Getter
    private final CarDealerRepo carDealerRepo;
    @Getter
    private final CarDealer carDealer;
    @Getter
    private final BankAccount bankAccount;

    @Autowired
    public MainService(PersonRepo personRepo, BankAccountRepo bankAccountRepo, CarRepo carRepo, CarDealer carDealer, CarDealerRepo carDealerRepo, BankAccount bankAccount) {
        this.personRepo = personRepo;
        this.bankAccountRepo = bankAccountRepo;
        this.carRepo = carRepo;
        this.carDealer = carDealer;
        this.carDealerRepo = carDealerRepo;
        this.bankAccount = bankAccount;

    }

    public void run () {
        log.info("Starting MainService - RUN");
        TablesLoad tablesLoad = new TablesLoad(this);
        tablesLoad.loadCars();
        tablesLoad.loadPersons();
        log.info("All Tables Loaded");
    }

}
