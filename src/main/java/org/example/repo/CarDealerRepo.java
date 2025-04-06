package org.example.repo;

import org.example.model.CarDealer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarDealerRepo extends JpaRepository<CarDealer, Long> {
}
