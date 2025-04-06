package org.example.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


@Entity
@Data
@NoArgsConstructor
@Component
public class Bank {

    private static final Bank BANK = new Bank();

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @OneToMany(
            mappedBy = "bank",
            cascade = CascadeType.ALL,
            orphanRemoval = true,
            fetch = FetchType.LAZY
    )
    private List<Person> persons = new ArrayList<>();
    private double balance;
    private String name;

    // Альтернативный конструктор
    public Bank(double initialBalance) {
        this.balance = initialBalance;
        this.name = "PowerBank";
    }

    // Методы для работы с персонами
    public void addPerson(Person person) {
        persons.add(person);
        person.setBank(this);
    }

    public void removePerson(Person person) {
        persons.remove(person);
        person.setBank(null);
    }


}
