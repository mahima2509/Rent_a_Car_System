package com.wipro.driverapi.service;

import java.util.List;

import com.wipro.driverapi.dto.DriverDTO;
import com.wipro.driverapi.entity.Driver;

public interface IDriverService {

    public Driver addDriver(DriverDTO driverDTO);
    
    public DriverDTO getById(int driverId);
    
    public List<Driver> getAllDrivers();
    
    public Driver updateDriver(DriverDTO driverDTO);

	public void deleteById(int driverId);

}
