package com.example.demo.Car;

import com.example.demo.Driver.Driver;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;


@Repository
public interface CarRepository extends JpaRepository<Car, UUID> {
    Optional<Car> findByDriver(Driver driver);

    void deleteByVIN(String vin);

    Optional<Car> findCarByVIN(String vin);
}
