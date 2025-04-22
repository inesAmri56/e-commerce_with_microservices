package com.example.driverservice.repository;


import com.example.driverservice.model.Driver;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DriverDAO  extends JpaRepository<Driver,Long> {
}
