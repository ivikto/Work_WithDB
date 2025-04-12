package org.example.service;

import lombok.Cleanup;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.example.model.BankAccount;
import org.example.model.Person;
import org.example.repo.BankAccountRepo;
import org.example.repo.CarDealerRepo;
import org.example.repo.CarRepo;
import org.example.repo.PersonRepo;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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


    @Autowired
    public MainService(PersonRepo personRepo, BankAccountRepo bankAccountRepo, CarRepo carRepo, CarDealerRepo carDealerRepo) {
        this.personRepo = personRepo;
        this.bankAccountRepo = bankAccountRepo;
        this.carRepo = carRepo;
        this.carDealerRepo = carDealerRepo;


    }

    @Transactional(readOnly = true)
    public void run() {

        List<PersonRepo.PersonBalanceProjection> persons = personRepo.findPeopleWithBalances();
        persons.forEach(p ->
                System.out.printf("│ %2d │ %-12s │ %3d │ %8.2f │%n",
                        p.getId(),
                        p.getUsername(),
                        p.getAge(),
                        p.getBalance())
        );


    }

    public void load() {
        log.info("Starting MainService - RUN");
        TablesLoad tablesLoad = new TablesLoad(this);
        tablesLoad.loadCars();
        tablesLoad.loadPersons();
        log.info("All Tables Loaded");
    }

}
