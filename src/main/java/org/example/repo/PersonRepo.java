package org.example.repo;

import org.example.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PersonRepo extends JpaRepository<Person, Long> {

    @Query(value = "SELECT * FROM person WHERE age > 20", nativeQuery = true)
    List<Person> findByAge();

    @Query(value = """
            SELECT
                p.id,
                p.username,
                p.age,
                b.balance
            FROM person p
                     JOIN bank_account b ON p.id = b.person_id
            WHERE b.balance = (SELECT MAX(b2.balance) FROM bank_account b2)
            """,
            nativeQuery = true)
    List<PersonBalanceProjection> findPeopleWithMaxBalances();

    @Query(value = """
            SELECT 
                p.id, 
                p.username, 
                p.age, 
                b.balance 
            FROM person p 
                JOIN bank_account b ON p.id = b.person_id
            """,
            nativeQuery = true)
    List<PersonBalanceProjection> findPeopleWithBalances();

    public interface PersonBalanceProjection {
        Long getId();
        String getUsername();
        int getAge();
        double getBalance();
    }



}
