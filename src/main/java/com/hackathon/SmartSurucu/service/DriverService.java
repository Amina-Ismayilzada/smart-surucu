package com.hackathon.SmartSurucu.service;


import com.hackathon.SmartSurucu.model.Driver;

import java.util.List;

public interface DriverService{
    public List<Driver> getAllDrivers();
    Driver getDriverById(Long id);
    public Driver saveDriver(Driver driver);

}
