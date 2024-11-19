package com.wipro.driverapi.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wipro.driverapi.dto.DriverDTO;
import com.wipro.driverapi.entity.Driver;
import com.wipro.driverapi.repository.DriverRepository;

@Service
public class DriverServiceImp implements IDriverService {

    @Autowired
    DriverRepository repo;

    Logger logger = LoggerFactory.getLogger(DriverServiceImp.class);

    @Override
    public Driver addDriver(DriverDTO driverDTO) {

        Driver driver = new Driver(); // entity class object

        driver.setDriverName(driverDTO.getDriverName());
        driver.setFare(driverDTO.getFare());
        driver.setRating(driverDTO.getRating());

        return repo.save(driver);
    }

    @Override
    public Driver updateDriver(DriverDTO driverDTO) {

        Driver driver = new Driver(); // entity class object
        
        driver.setDriverId(driverDTO.getDriverId());
        driver.setDriverName(driverDTO.getDriverName());
        driver.setFare(driverDTO.getFare());
        driver.setRating(driverDTO.getRating());

        return repo.save(driver);
    }

    @Override
    public DriverDTO getById(int driverId) {

        Driver driver = repo.findById(driverId).orElse(new Driver());

        DriverDTO driverDTO = new DriverDTO();

        driverDTO.setDriverId(driver.getDriverId());
        driverDTO.setDriverName(driver.getDriverName());
        driverDTO.setFare(driver.getFare());
        driverDTO.setRating(driver.getRating());
        
        return driverDTO;
    }

    @Override
    public List<Driver> getAllDrivers() {

        logger.info("Fetching all drivers from service class");
        logger.warn("Fetching all drivers from service class");
        return repo.findAll();
    }

    @Override
	public void deleteById(int driverId) {
	    Driver driver = repo.findById(driverId)
	                  .orElseThrow(() -> new RuntimeException("Driver with ID " + driverId + " not found."));
	    repo.delete(driver);  // Delete the cab from the repository
	    System.out.println("Driver with ID " + driverId + " deleted successfully.");
	}
}
