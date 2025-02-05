package com.example.demo.DTO;

import lombok.*;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class DriverDtoCreateUpdate {
    private String pesel;
    private String name;
    private String surname;
    private int age;

    public DriverDtoCreateUpdate(String pesel, String name, String surname, int age) {
        this.pesel = pesel;
        this.name = name;
        this.surname = surname;
        this.age = age;
    }
}
