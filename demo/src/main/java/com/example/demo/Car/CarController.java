package com.example.demo.Car;


import com.example.demo.DTO.CarDtoCreateUpdate;
import com.example.demo.DTO.CarDtoRead;
import com.example.demo.DTO.DriverDtoRead;
import com.example.demo.Driver.Driver;
import com.example.demo.Driver.DriverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;


@RestController
public class CarController {
    private final CarService carService;
    private final DriverService driverService;

    @Autowired
    public CarController(CarService carService, DriverService driverService) {
        this.carService = carService;
        this.driverService = driverService;
    }

    private CarDtoRead convertToDto(Car car) {
        CarDtoRead dto = new CarDtoRead();
        dto.setId(car.getId());
        dto.setBrand(car.getBrand());
        dto.setModel(car.getModel());
        dto.setVIN(car.getVIN());
        dto.setDrivers_pesel(car.getDriver().getPesel());
        return dto;
    }

    @GetMapping("api/cars")
    public List<CarDtoRead> getAllCars() {
        return ResponseEntity.ok(carService.getCars().stream()
                .map(this::convertToDto)
                .collect(Collectors.toList())).getBody();
    }



    @GetMapping("api/drivers/{driver_id}/cars")
    public ResponseEntity<Object> getCarByDriverId(@PathVariable("driver_id") UUID driver_id) {
        Optional<Driver> driver = driverService.getDriverById(driver_id);
        if(driver.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(driver.get().getCars().stream().map(this::convertToDto).collect(Collectors.toList()));
    }

    @GetMapping("api/cars/{id}")
    public ResponseEntity<Object> getCarById(@PathVariable("id") UUID car_id) {
        Optional<Car> car = carService.getCarById(car_id);
        if(car.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(convertToDto(car.get()));
    }

    @DeleteMapping("api/cars/{id}")
    public ResponseEntity<Object> deleteCarById(@PathVariable("id") UUID car_id) {
        Optional<Car> car = carService.getCarById(car_id);
        if(car.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        carService.delete(car_id);
        return ResponseEntity.accepted().build();
    }

    @PatchMapping("api/cars/{id}")
    public ResponseEntity<Object> updateCarById(@PathVariable("id") UUID car_id, @RequestBody CarDtoCreateUpdate carDto) {
        Optional<Car> car = carService.getCarById(car_id);
        if(car.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        else{
            car.get().setModel(carDto.getModel());
            car.get().setBrand(carDto.getBrand());
            car.get().setVIN(carDto.getVIN());
            carService.save(car.get());
            return ResponseEntity.noContent().build();
        }
    }

    @PostMapping("api/drivers/{driver_id}/cars")
    public ResponseEntity<Object> addCar(@PathVariable("driver_id") UUID driver_id, @RequestBody CarDtoCreateUpdate carDto) {
        Optional<Driver> driver = driverService.getDriverById(driver_id);
        if(driver.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        Car car = Car.builder().id(UUID.randomUUID()).VIN(carDto.getVIN()).brand(carDto.getBrand()).model(carDto.getModel()).
                driver(driver.get()).build();
        carService.save(car);
        driver.get().getCars().add(car);
        driverService.save(driver.get());
        return ResponseEntity.created(URI.create("http://localhost:8080/api/drivers")).build();
    }
}
