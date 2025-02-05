package com.example.demo.Driver;

import com.example.demo.Car.Car;
import com.example.demo.Car.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
public class DriverController {
    private final DriverService driverService;

    @Autowired
    DriverController(DriverService driverService) {
        this.driverService = driverService;
    }


    @DeleteMapping("api/drivers/{id}")
    public ResponseEntity<Object> deleteDriverById(@PathVariable UUID id) {
        Driver driver = driverService.getDriverById(id).orElse(null);
        if (driver == null) {
            return ResponseEntity.notFound().build();
        } else{
            driverService.delete(id);
            return ResponseEntity.accepted().build();
        }
    }

    @PostMapping("api/drivers")
    public ResponseEntity<Object> createDriver(@RequestBody Driver driver) {
        driverService.save(driver);
        return ResponseEntity.created(URI.create("/api/drivers/")).build();
    }





}
