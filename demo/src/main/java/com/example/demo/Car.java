package com.example.demo;

import java.io.Serializable;
import java.util.Objects;
import java.util.UUID;

import jakarta.persistence.*;
import lombok.*;
import jakarta.persistence.Entity;


@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
//@ToString
@Entity
@Table(name="cars")
public class Car implements Comparable<Car> , Serializable{

    @Id
    private UUID id;

    private String VIN;

    private String brand;

    private String model;


    @ManyToOne
    @JoinColumn(name = "cars")
    private Driver driver;

    @Override
    public String toString() {
        return "Car{" +
                "VIN='" + VIN + '\'' +
                ", brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return Objects.equals(VIN, car.VIN) && Objects.equals(brand, car.brand) && Objects.equals(model, car.model);
    }

    @Override
    public int hashCode() {
        return Objects.hash(VIN, brand, model);
    }

    @Override
    public int compareTo(Car o) {
        return 0;
    }
}
