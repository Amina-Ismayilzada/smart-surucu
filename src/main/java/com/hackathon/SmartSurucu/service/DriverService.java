package com.hackathon.SmartSurucu.service;


import com.hackathon.SmartSurucu.model.Driver;

import java.util.List;

public interface DriverService{
    public Driver saveDriver(Driver driver);
    public List<Driver> getAllDrivers();

    Driver getDriverById(Long id);
}
