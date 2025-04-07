package org.example.repo;

import org.example.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PersonRepo extends JpaRepository<Person, Long> {

    @Query(value = "SELECT * FROM person WHERE age > 20", nativeQuery = true)
    List<Person> findByAge();

}
