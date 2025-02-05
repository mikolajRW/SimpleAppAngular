package com.example.demo.DTO;


import lombok.*;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class CarDtoCreateUpdate{

    private String VIN;
    private String brand;
    private String model;

    public CarDtoCreateUpdate(String VIN, String brand, String model) {
        this.VIN = VIN;
        this.brand = brand;
        this.model = model;
    }

}
