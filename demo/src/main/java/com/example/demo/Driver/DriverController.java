package com.example.demo.Driver;

import com.example.demo.Car.Car;
import com.example.demo.Car.CarController;
import com.example.demo.Car.CarService;
import com.example.demo.DTO.DriverDtoCreateUpdate;
import com.example.demo.DTO.DriverDtoRead;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
public class DriverController {
    private final DriverService driverService;
    private final CarService carService;

    @Autowired
    DriverController(DriverService driverService, CarService carService) {
        this.driverService = driverService;
        this.carService = carService;
    }


    private DriverDtoRead convertToDto(Driver driver) {
        DriverDtoRead dto = new DriverDtoRead();
        dto.setId(driver.getDriver_id());
        dto.setPesel(driver.getPesel());
        dto.setSurname(driver.getSurname());
        dto.setCarsVin(driver.getCars().stream()
                .map(Car::getVIN)
                .collect(Collectors.toList()));
        return dto;
    }

    @GetMapping("api/drivers")
    public List<DriverDtoRead> getAllDrivers() {
        return driverService.getDrivers().stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    @GetMapping("api/drivers/{id}")
    public ResponseEntity<Object> getDriverById(@PathVariable UUID id) {
        Driver driver = driverService.getDriverById(id).orElse(null);
        if (driver == null) {
            return ResponseEntity.notFound().build();
        }else{
            return ResponseEntity.ok(convertToDto(driver));
        }
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
    public ResponseEntity<Object> addDriver(@RequestBody DriverDtoCreateUpdate dto) {
        Driver driver = Driver.builder().driver_id(UUID.randomUUID()).pesel(dto.getPesel()).surname(dto.getSurname())
                .cars(null).name(null).age(0).build();
        driverService.save(driver);
        return ResponseEntity.created(URI.create("http://localhost:8080/api/drivers")).build();
    }

    @PatchMapping("api/drivers/{id}")
    public ResponseEntity<Object> updateDriver(@PathVariable UUID id, @RequestBody DriverDtoCreateUpdate dto) {
        Driver driver = driverService.getDriverById(id).orElse(null);
        if (driver == null) {
            return ResponseEntity.notFound().build();
        }
        driver.setPesel(dto.getPesel());
        driver.setSurname(dto.getSurname());
        driverService.save(driver);
        return ResponseEntity.noContent().build();
    }



}
