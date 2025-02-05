package com.example.demo.DTO;

import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class DriverDtoRead {

    private UUID id;
    private String pesel;
    private String surname;
    private List<String> carsVin;

    public DriverDtoRead(String surname,String pesel, UUID id, List<String> carsVin) {
        this.pesel = pesel;
        this.id = id;
        this.surname = surname;
        this.carsVin = carsVin;
    }
}
