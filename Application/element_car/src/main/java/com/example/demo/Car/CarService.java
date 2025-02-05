package com.example.demo.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class CarService {
    private final CarRepository carRepository;

    @Autowired
    public CarService(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    public List<Car> getCars() {
        return carRepository.findAll();
    }

    public Optional<Car> getCarById(UUID id) {
        return carRepository.findById(id);
    }

    public Optional<Car> getCarByVin(String vin) {
        return carRepository.findCarByVIN(vin);
    }

    public void save(Car car) {
        carRepository.save(car);
    }

    public void delete(UUID id) {
        carRepository.deleteById(id);
    }

    public void deleteByVin(String vin) {
        carRepository.deleteByVIN(vin);
    }

}
