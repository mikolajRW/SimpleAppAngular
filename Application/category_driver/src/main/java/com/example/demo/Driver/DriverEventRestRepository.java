package com.example.demo.Driver;

import com.example.demo.DTO.DriverDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import java.util.UUID;

@Repository
public class DriverEventRestRepository {

    private final RestTemplate restTemplate;

    @Autowired
    public DriverEventRestRepository(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public void delete(UUID id) {
        restTemplate.delete("/api/drivers/{id}", id);
    }

    public void create(Driver driver) {
       restTemplate.postForEntity("/api/drivers",driver, Driver.class);
    }

}
