package com.example.demo.Driver;
import java.util.List;

import java.io.Serializable;
import java.util.Objects;
import java.util.UUID;

import com.example.demo.Car.Car;
import jakarta.persistence.*;
import lombok.*;


@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
//@ToString
//@EqualsAndHashCode
@Entity
@Table(name="drivers")
public class Driver implements Comparable<Driver> , Serializable{
    @Id
    private UUID driver_id;

    private String pesel;

    private String name;

    private String surname;

    private int age;

    @OneToMany(mappedBy = "driver", cascade = CascadeType.REMOVE, fetch = FetchType.EAGER)
    private List<Car> cars;

    @Override
    public String toString() {
        return "Driver{" +
                "pesel='" + pesel + '\'' +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", age="+ age +
                ", cars=" + cars +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Driver driver = (Driver) o;
        return Objects.equals(pesel, driver.pesel) && Objects.equals(name, driver.name) && Objects.equals(surname, driver.surname) && Objects.equals(age, driver.age) && Objects.equals(cars, driver.cars);
    }

    @Override
    public int hashCode() {
        return Objects.hash(pesel, name, surname, age, cars);
    }


    @Override
    public int compareTo(Driver o) {
        return 0;
    }


}
