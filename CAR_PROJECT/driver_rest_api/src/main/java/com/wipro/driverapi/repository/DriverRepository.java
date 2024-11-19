package com.wipro.driverapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wipro.driverapi.entity.Driver;

@Repository
public interface DriverRepository extends JpaRepository<Driver, Integer> {

}
