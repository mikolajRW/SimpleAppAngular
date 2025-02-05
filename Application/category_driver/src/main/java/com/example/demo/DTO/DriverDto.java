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
public class DriverDto {
    private UUID driverId;
    private String pesel;
    private String name;
    private String surname;
    private int age;

    public DriverDto(String pesel, String name, String surname, int age, UUID driverId) {
        this.pesel = pesel;
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.driverId = driverId;
    }
}
