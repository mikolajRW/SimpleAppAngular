package com.example.demo.Driver;

import com.example.demo.DTO.DriverDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
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


    private DriverDto convertToDto(Driver driver) {
        DriverDto dto = new DriverDto();
        dto.setPesel(driver.getPesel());
        dto.setSurname(driver.getSurname());
        dto.setName(driver.getName());
        dto.setDriverId(driver.getDriver_id());
        dto.setAge(driver.getAge());
        return dto;
    }


    @GetMapping("api/drivers")
    public List<DriverDto> getAllDrivers() {
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
    public ResponseEntity<Object> createDriver(@RequestBody DriverDto dto) {
        Driver driver = Driver.builder().pesel(dto.getPesel()).name(dto.getName()).age(dto.getAge()).
                surname(dto.getSurname()).driver_id(UUID.randomUUID()).build();
        driverService.save(driver);
        return ResponseEntity.created(URI.create("http://localhost:8082/api/drivers")).build();
    }



}
