package com.example.demo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class DriverService  {
    private final DriverRepository driverRepository;

    @Autowired
    public DriverService( DriverRepository driverRepository) {
        this.driverRepository = driverRepository;
    }

    public List<Driver> getDrivers() {
        return driverRepository.findAll();
    }


    public void save(Driver driver) {
        driverRepository.save(driver);
    }


    public void delete(UUID id) {
        driverRepository.deleteById(id);
    }

    public Optional<Driver> getDriverByPesel(String pesel) {
        return driverRepository.findDriverByPesel(pesel);
    }

    public Optional<Driver> getDriverById(UUID id) {
        return driverRepository.findById(id);
    }

}

