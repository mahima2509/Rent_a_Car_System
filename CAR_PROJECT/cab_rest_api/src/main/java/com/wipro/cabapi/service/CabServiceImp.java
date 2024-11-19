package com.wipro.cabapi.service;

import java.util.ArrayList;
import java.util.List;

import com.wipro.cabapi.dto.CabDetails;
import com.wipro.cabapi.entity.Driver;
import com.wipro.cabapi.repository.DriverRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.wipro.cabapi.dto.CabDTO;
import com.wipro.cabapi.dto.CabDriverVO;
import com.wipro.cabapi.entity.Cab;
import com.wipro.cabapi.repository.CabRepository;

@Service
public class CabServiceImp implements ICabService {

    @Autowired
    CabRepository repo;
    @Autowired
    DriverRepo driverRepo;

    @Autowired
    RestTemplate restTemplate;

    @Override
    public Cab addCab(CabDTO cabDTO) {

        Cab cab = new Cab();
        cab.setCabId(cabDTO.getCabId());
        cab.setCabName(cabDTO.getCabName());
        cab.setDateOfBook(cabDTO.getDateOfBook());
        cab.setDriverId(cabDTO.getDriverId());

        return repo.save(cab);
    }

    @Override
    public CabDTO getCabById(int cabId) {

        Cab cab = repo.findById(cabId).orElse(null);

        CabDTO dto = new CabDTO();
        dto.setCabId(cab.getCabId());
        dto.setCabName(cab.getCabName());
        dto.setDateOfBook(cab.getDateOfBook());
        dto.setDriverId(cab.getDriverId());

        return dto;
    }

    @Override
    public List<CabDetails> getAllCabs() {
        List<Cab> carList = repo.findAll();
        List<CabDetails> cabDetailsList = new ArrayList<>();

        carList.forEach(car -> {
            Driver driver = driverRepo.findById(car.getDriverId()).orElse(null);
            if (driver != null) {
                CabDetails cab = new CabDetails.Builder()
                        .cabId((long) car.getCabId())
                        .cabName(car.getCabName())
                        .dateOfBook(car.getDateOfBook().toString())
                        .driverId((long) driver.getDriverId())
                        .driverName(driver.getDriverName())
                        .driverRating(driver.getRating())
                        .build();

                cabDetailsList.add(cab);
            }
        });

        return cabDetailsList;
    }



//    @Override
//    public CabDriverVO getCabAndDriverById(int cabId) {
//
//        // step1
//        CabDTO cab = getCabById(cabId);
//
//        int driverId = cab.getDriverId();
//
//        // step2: call rest api from driver microservice
//        Driver driver = restTemplate.getForObject("http://localhost:8282/api/drivers/get/" + driverId, Driver.class);
//
//        CabDriverVO cabDriverVO = new CabDriverVO();
//        cabDriverVO.setCab(cab);
//        cabDriverVO.setDriver(driver);
//
//        return cabDriverVO;
//    }

    /*
     * @Override public void updateDriverByCab(Driver driver) {
     * restTemplate.put("http://localhost:8282/api/drivers/update", driver);
     * System.out.println("Updated driver information from cab MS"); }
     */

    @Override
    public Cab updateCab(CabDTO cabDTO) {
        // TODO Auto-generated method stub
        Cab cab = new Cab();
        cab.setCabId(cabDTO.getCabId());
        cab.setCabName(cabDTO.getCabName());
        cab.setDateOfBook(cabDTO.getDateOfBook());
        cab.setDriverId(cabDTO.getDriverId());

        return repo.save(cab);
    }

    @Override
    public void deleteById(int cabId) {
        Cab cab = repo.findById(cabId).orElseThrow(() -> new RuntimeException("Cab with ID " + cabId + " not found."));
        repo.delete(cab);  // Delete the cab from the repository
        System.out.println("Cab with ID " + cabId + " deleted successfully.");
    }

    /*
     * @Override public Cab deleteCab(CabDTO cabDTO) { // TODO Auto-generated method
     * stub return null; }
     */
    /*
     * @Override public void deleteCabById(int cabId) { // Step 1: Retrieve the cab
     * by ID (if exists) Cab cab = repo.findById(cabId).orElseThrow(() -> new
     * RuntimeException("Cab with ID " + cabId + " not found.") );
     *
     * // Step 2: Delete the cab from the repository return repo.delete(cab);
     *
     * System.out.println("Cab with ID " + cabId + " deleted successfully."); }
     */


}
