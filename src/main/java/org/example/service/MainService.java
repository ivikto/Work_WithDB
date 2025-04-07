package org.example.service;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.example.model.BankAccount;
import org.example.model.Person;
import org.example.repo.BankAccountRepo;
import org.example.repo.CarDealerRepo;
import org.example.repo.CarRepo;
import org.example.repo.PersonRepo;
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
    public void run () {


        List<Person> persons = personRepo.findByAge();
        persons.forEach(System.out::println);
        System.out.println(persons.size());
        double balance = 5000000;
        List<BankAccount> bankAccounts = bankAccountRepo.findByBalance(balance);
        bankAccounts.forEach(System.out::println);
        System.out.println("Количество аккаунтов у которых на счету: " + balance + " руб : " + bankAccounts.size());


    }

    public void load() {
        log.info("Starting MainService - RUN");
        TablesLoad tablesLoad = new TablesLoad(this);
        tablesLoad.loadCars();
        tablesLoad.loadPersons();
        log.info("All Tables Loaded");
    }

}
