package com.example.demo;


import lombok.*;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class CarDto implements Comparable<Car>{

    private String VIN;
    private String brand;
    private String model;
    private int year;
    private String pesel;

    public CarDto(String VIN, String brand, String model, int year, String pesel) {
        this.VIN = VIN;
        this.brand = brand;
        this.model = model;
        this.year = year;
        this.pesel = pesel;
    }

    @Override
    public int compareTo(Car o) {
        return 0;
    }
}
