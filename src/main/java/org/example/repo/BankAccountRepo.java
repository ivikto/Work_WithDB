package org.example.repo;

import org.example.model.BankAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface BankAccountRepo extends JpaRepository<BankAccount, Long> {

    @Query(value = "SELECT * FROM bank_account WHERE balance > :balance", nativeQuery = true)
    List<BankAccount> findByBalance(@Param("balance") double balance);
}
