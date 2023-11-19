package com.hackathon.SmartSurucu.model.dataseed;

import com.hackathon.SmartSurucu.model.Car;
import com.hackathon.SmartSurucu.model.Driver;
import com.hackathon.SmartSurucu.model.DrivingBehaviour;
import com.hackathon.SmartSurucu.model.DrivingStatus;
import com.hackathon.SmartSurucu.repository.CarRepository;
import com.hackathon.SmartSurucu.repository.DriverRepository;
import com.hackathon.SmartSurucu.repository.DrivingBehaviourRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class DataSeeder implements CommandLineRunner {

    @Autowired
    private CarRepository carRepository;

    @Autowired
    private DriverRepository driverRepository;

    @Autowired
    private DrivingBehaviourRepository drivingBehaviourRepository;

    @Override
    public void run(String... args) throws Exception {
        seedData();
    }

    private void seedData() {
        if (driverRepository.count() == 0) {
            // Create sample driver
            Driver driver = new Driver("Ziya", "Namazov", "6GI20DR", "0516473856", null);
            driverRepository.save(driver);

            // Create and save sample cars
            Car car1 = new Car("Toyota", "Camry", "Blue", 2020, 2.5, "ABC123", 25000.0, driver);
            Car car2 = new Car("Honda", "Accord", "Red", 2019, 2.0, "XYZ456", 22000.0, driver);

            carRepository.save(car1);
            carRepository.save(car2);

            // Create and save sample driving behaviour
            DrivingBehaviour drivingBehaviour = new DrivingBehaviour(driver.getId(), driver, DrivingStatus.GREAT, 0, 0, 0, 0, 0, 0, 130.0);
            drivingBehaviourRepository.save(drivingBehaviour);
        }
    }
}
