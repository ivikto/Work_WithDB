package org.example.model;


import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "car_dealers")
@Data
@NoArgsConstructor
@Component
public class CarDealer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @OneToMany(
            mappedBy = "dealer",
            cascade = {CascadeType.PERSIST, CascadeType.MERGE},
            orphanRemoval = true,
            fetch = FetchType.LAZY
    )
    private List<Car> cars = new ArrayList<>();

    @Column(nullable = false, length = 100)
    private String name = "BestCarSeller";


    public CarDealer(String name) {
        this.name = name;
    }

    public void addCar(Car car) {
        cars.add(car);
        car.setDealer(this);
    }

    public void removeCar(Car car) {
        cars.remove(car);
        car.setDealer(null);
    }

}