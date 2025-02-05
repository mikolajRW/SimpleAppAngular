package com.example.demo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;



public interface DriverRepository extends JpaRepository<Driver, UUID> {
    Optional<Driver> findDriverByPesel(String pesel);
}

