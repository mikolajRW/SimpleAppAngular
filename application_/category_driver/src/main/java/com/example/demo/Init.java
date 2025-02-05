package com.example.demo;

import com.example.demo.Driver.Driver;
import com.example.demo.Driver.DriverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Component
public class Init {
    private final DriverService driverS;


    @Autowired
    public Init(DriverService driverS) {
        this.driverS = driverS;

    }

    public void init() {
        Driver driver1 = Driver.builder()
                .driver_id(UUID.fromString("a1234567-89ab-4cde-bf01-23456789abcd"))
                .pesel("12345678901")
                .name("John")
                .surname("Doe")
                .build();
        driver1.setAge(35);

        Driver driver2 = Driver.builder()
                .driver_id(UUID.fromString("b2345678-90bc-4def-af12-34567890bcde"))
                .pesel("98765432109")
                .name("Jane")
                .surname("Smith")
                .build();
        driver2.setAge(29);

        driverS.save(driver1);
        driverS.save(driver2);


        System.out.println("Data initialized");

    }

}
