package com.example.demo.DTO;

import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.UUID;

@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class CarDtoRead {
    private UUID id;
    private String VIN;
    private String brand;
    private String model;
    private String drivers_pesel;

    public CarDtoRead(UUID id, String VIN, String brand, String model, String drivers_pesel) {
        this.id = id;
        this.VIN = VIN;
        this.brand = brand;
        this.model = model;
        this.drivers_pesel = drivers_pesel;
    }





}
