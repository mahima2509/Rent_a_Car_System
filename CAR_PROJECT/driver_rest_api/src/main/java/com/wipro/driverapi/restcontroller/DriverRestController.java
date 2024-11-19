package com.wipro.driverapi.restcontroller;

import java.util.List;

import jakarta.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wipro.driverapi.dto.DriverDTO;
import com.wipro.driverapi.entity.Driver;
import com.wipro.driverapi.exception.DriverNotFoundException;
import com.wipro.driverapi.service.IDriverService;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import com.wipro.driverapi.util.*;

@CrossOrigin("http://localhost:4200")
@RestController
@RequestMapping("/api/drivers")
public class DriverRestController {

    Logger logger = LoggerFactory.getLogger(DriverRestController.class);

    @Autowired
    IDriverService service;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    private boolean authenticate(HttpServletRequest request) {
        // Get the Authorization header from the request
        String authHeader = request.getHeader("Authorization");

        if (authHeader != null && authHeader.startsWith("Bearer ")) {
            // Extract the token from the header
            String token = authHeader.substring(7); // Remove "Bearer " prefix

            // Validate the token
            return jwtTokenUtil.validateToken(token);
        }

        return false; // Token is not present or invalid
    }

    @PostMapping(value="/add",produces = "application/json", consumes = "application/json")
    public Driver addDriver(@RequestBody DriverDTO driverDTO,HttpServletRequest request) {
        if (!authenticate(request)) {
            return null;
        }
        return service.addDriver(driverDTO);
    }

    @PutMapping(value="/update",produces = "application/json", consumes = "application/json")
    public Driver updateDriver(@RequestBody DriverDTO driverDTO,HttpServletRequest request) {
        if (!authenticate(request)) {
            return null;
        }
        return service.updateDriver(driverDTO);
    }

    @GetMapping("/get/{driverId}")
    public DriverDTO getById(@PathVariable @Valid @Min(1) int driverId,HttpServletRequest request) throws DriverNotFoundException {
        if (!authenticate(request)) {
            return null;
        }
        DriverDTO driverDTO = service.getById(driverId);

        if (driverDTO.getDriverId() == 0) {
            throw new DriverNotFoundException(HttpStatus.BAD_REQUEST, "Driver Not Found for DriverId : " + driverId);
        }

        return driverDTO;
    }

	/*
	 * @DeleteMapping("/deletebyid/{driverId}") public ResponseEntity<String>
	 * deleteById(@PathVariable int driverId) { service.deleteById(driverId); return
	 * new ResponseEntity<>("Driver deleted successfully", HttpStatus.OK); }
	 */
    @DeleteMapping("/deletebyid/{driverId}")
    public String deleteDriverById(@PathVariable int driverId,HttpServletRequest request) {
        if (!authenticate(request)) {
            return null;
        }
        service.deleteById(driverId);  // Call service to delete the cab
        return "Driver with ID " + driverId + " deleted successfully.";
    }
    @GetMapping("/getall")
    public List<Driver> getAllDrivers(HttpServletRequest request) {
        if (!authenticate(request)) {
            return null;
        }
        logger.debug("I am debug");
        logger.info("I am info");
        logger.warn("I am warning");
        logger.error("I am error");

        return service.getAllDrivers();
    }

    @ExceptionHandler({DriverNotFoundException.class})
    public ResponseEntity<String> handleDriverNotFoundExp(DriverNotFoundException de) {
        return new ResponseEntity<String>(de.getMessage(), HttpStatus.BAD_REQUEST);
    }
}
