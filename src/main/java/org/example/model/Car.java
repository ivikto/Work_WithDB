package org.example.model;


import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
public class Car {


    @Id
    @Setter(AccessLevel.PRIVATE)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false, length = 50)
    private String model;
    @Column(nullable = false, length = 30)
    private String color;
    @Column(name = "max_speed")
    private int maxSpeed;
    private double price;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "dealer_id")
    private CarDealer dealer;

    public Car(String model, String color, int maxSpeed, double price, CarDealer dealer) {
        this.model = model;
        this.color = color;
        this.maxSpeed = maxSpeed;
        this.price = price;
        this.dealer = dealer;
    }
}
