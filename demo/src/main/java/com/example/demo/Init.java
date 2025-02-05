package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Component
public class Init {
    private final DriverService driverS;
    private final CarService carS;


    @Autowired
    public Init(DriverService driverS, CarService carS) {
        this.driverS = driverS;
        this.carS = carS;
    }

    public void init() {
        Driver driver1 = Driver.builder()
                .driver_id(UUID.fromString("a1234567-89ab-4cde-bf01-23456789abcd"))
                .pesel("12345678901")
                .name("John")
                .surname("Doe")
                .age(35)
                .cars(new ArrayList<>())
                .build();

        Driver driver2 = Driver.builder()
                .driver_id(UUID.fromString("b2345678-90bc-4def-af12-34567890bcde"))
                .pesel("98765432109")
                .name("Jane")
                .surname("Smith")
                .age(29)
                .cars(new ArrayList<>())
                .build();

        driverS.save(driver1);
        driverS.save(driver2);

        // Create cars and assign to drivers
        Car car1 = Car.builder()
                .id(UUID.fromString("c3456789-01cd-4efa-bf23-45678901cdef"))
                .VIN("1HGBH41JXMN109186")
                .brand("Toyota")
                .model("Corolla")
                .driver(driver1)
                .build();

        Car car2 = Car.builder()
                .id(UUID.fromString("d4567890-12de-4fab-cf34-56789012defa"))
                .VIN("1HGCM82633A123456")
                .brand("Honda")
                .model("Civic")
                .driver(driver1)
                .build();

        Car car3 = Car.builder()
                .id(UUID.fromString("e5678901-23ef-4bca-df45-67890123efbc"))
                .VIN("1FAFP40413F123456")
                .brand("Ford")
                .model("Focus")
                .driver(driver2)
                .build();

        carS.save(car1);
        carS.save(car2);
        carS.save(car3);

        // Add cars to drivers' car lists
        driver1.getCars().addAll(List.of(car1, car2));
        driver2.getCars().add(car3);

        // Update drivers with their cars
        driverS.save(driver1);
        driverS.save(driver2);
        System.out.println("Data initialized");

    }

}
