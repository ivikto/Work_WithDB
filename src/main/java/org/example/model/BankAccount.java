package org.example.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;


@Entity
@Data
@NoArgsConstructor
@Component
public class BankAccount {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "person_id")
    private Person person;
    private double balance;
    private final String name = "BestBank";


    public BankAccount(Person person, double initialBalance) {
        this.person = person;
        this.balance = initialBalance;
    }

    public static BankAccount addAccount(Person person, double initialBalance) {
        BankAccount bankAccount = new BankAccount(person, initialBalance);
        return bankAccount;
    }
}
