package org.example.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@ToString(exclude = "accounts")
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id ;
    private String username;
    @NotNull
    private int age;

    @OneToMany(mappedBy = "person", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<BankAccount> accounts = new ArrayList<>();


    public Person(String username, int age) {
        this.username = username;
        this.age = age;
    }

}

