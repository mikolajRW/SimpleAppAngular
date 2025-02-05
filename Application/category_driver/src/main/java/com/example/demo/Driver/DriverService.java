package com.example.demo.Driver;
import com.example.demo.DTO.DriverDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class DriverService  {
    private final DriverRepository driverRepository;
    private final DriverEventRestRepository driverEventRestRepository;


    @Autowired
    public DriverService(DriverRepository driverRepository, DriverEventRestRepository driverEventRestRepository) {
        this.driverRepository = driverRepository;
        this.driverEventRestRepository = driverEventRestRepository;
    }

    public List<Driver> getDrivers() {
        return driverRepository.findAll();
    }


    public void save(Driver driver) {
        driverRepository.save(driver); driverEventRestRepository.create(driver);
    }



    public void delete(UUID id) {
        driverRepository.deleteById(id); driverEventRestRepository.delete(id);
    }

    public Optional<Driver> getDriverByPesel(String pesel) {
        return driverRepository.findDriverByPesel(pesel);
    }

    public Optional<Driver> getDriverById(UUID id) {
        return driverRepository.findById(id);
    }

}

