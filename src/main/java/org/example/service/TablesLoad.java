package org.example.service;

import org.example.model.BankAccount;
import org.example.model.Car;
import org.example.model.CarDealer;
import org.example.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


@Component
public class TablesLoad {

    private MainService mainService;

    @Autowired
    public TablesLoad(MainService mainService) {
        this.mainService = mainService;
    }


    // Persons
    public void loadPersons() {

        List<Person> people = getPeople();
        List<BankAccount> bankAccounts = new ArrayList<>();
        mainService.getPersonRepo().saveAll(people);
        for (Person p : people) {
            BankAccount bankAccount = mainService.getBankAccount().addAccount(p, Math.round(Math.random() * 10000000));
            bankAccounts.add(bankAccount);
        }
        mainService.getBankAccountRepo().saveAll(bankAccounts);


    }
    private static List<Person> getPeople() {
        Person person1 = new Person("Вадим", 43);
        Person person2 = new Person("Кирилл", 21);
        Person person3 = new Person("Николай", 52);
        Person person4 = new Person("Виктор", 41);
        Person person5 = new Person("Анатолий", 62);
        Person person6 = new Person("Валерий", 25);
        Person person7 = new Person("Олег", 18);
        Person person8 = new Person("Сергей", 27);
        Person person9 = new Person("Юрий", 20);
        Person person10 = new Person("Даниил", 50);
        List<Person> people = Arrays.asList(person1, person2, person3, person4, person5, person6, person7, person8, person9, person10);
        return people;
    }

    public void loadCars() {
        Car car = new Car("BMW M5", "Синий", 250, 8000000, mainService.getCarDealer());
        Car car1 = new Car("Audi R8", "Красный", 270, 10000000, mainService.getCarDealer());
        Car car2 = new Car("Chevrolet Cruze", "Бежевый", 180, 1000000, mainService.getCarDealer());
        Car car3 = new Car("Lada Vesta", "Белый",  180,1800000, mainService.getCarDealer());
        Car car4 = new Car("Lada Largus", "Коричневый",  160,1600000, mainService.getCarDealer());
        Car car5 = new Car("Jeely Tugela", "Голубой",  200, 3600000,mainService.getCarDealer());
        Car car6 = new Car("Mercedes C-class", "Черный",  250,8500000, mainService.getCarDealer());
        Car car7 = new Car("Jetour T2", "Бежевый", 180, 3500000,mainService.getCarDealer());
        Car car8 = new Car("Honda Accord", "Черный", 210, 2000000, mainService.getCarDealer());
        Car car9 = new Car("Mitsubishi Lancer EVO", "Красный", 240, 3000000, mainService.getCarDealer());
        Car car10 = new Car("Chery Tigo", "Голубой", 200, 4500000, mainService.getCarDealer());
        List<Car> cars = Arrays.asList(car, car1, car2, car3, car4, car5, car6, car7, car8, car9, car10);
        CarDealer dealer = mainService.getCarDealer();
        for (Car c : cars) {
            dealer.addCar(c);
        }
        mainService.getCarDealerRepo().save(dealer);
        mainService.getCarRepo().saveAll(cars);



    }
}
