package com.wipro.cabapi.repository;

import com.wipro.cabapi.entity.Driver;
import org.springframework.data.jpa.repository.JpaRepository;
import com.wipro.cabapi.entity.Cab;

public interface DriverRepo extends JpaRepository<Driver, Integer> {

}

