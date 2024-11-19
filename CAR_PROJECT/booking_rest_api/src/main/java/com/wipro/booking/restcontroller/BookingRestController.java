package com.wipro.booking.restcontroller;

import java.util.List;

import com.wipro.booking.util.JwtTokenUtil;
import jakarta.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wipro.booking.dto.BookingDTO;
import com.wipro.booking.entity.Booking;
import com.wipro.booking.service.IBookingService;

//import jakarta.validation.Valid;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/bookings")
public class BookingRestController {

    Logger logger = LoggerFactory.getLogger(BookingRestController.class);

    @Autowired
    IBookingService service;
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

    @PostMapping(value = "/add", produces = "application/json", consumes = "application/json")
    public Booking addBooking(@RequestBody BookingDTO bookingDTO, HttpServletRequest request) {
        if (!authenticate(request)) {
            return null;
        }
        return service.addBooking(bookingDTO);
    }

    @PutMapping(value = "/update", produces = "application/json", consumes = "application/json")
    public Booking updateBooking(@RequestBody BookingDTO bookingDTO, HttpServletRequest request) {

        if (!authenticate(request)) {
            return null;
        }
        return service.updateBooking(bookingDTO);
    }

    @GetMapping("/get/{bookingId}")
    public BookingDTO getById(@PathVariable int bookingId, HttpServletRequest request) {
        if (!authenticate(request)) {
            return null;
        }
        return service.getById(bookingId);
    }

    @DeleteMapping("/deletebyid/{bookingId}")
    public ResponseEntity<String> deleteById(@PathVariable int bookingId, HttpServletRequest request) {
        if (!authenticate(request)) {
            return null;
        }
        service.deleteById(bookingId);
        return new ResponseEntity<>("Booking with ID " + bookingId + " deleted successfully.", HttpStatus.OK);
    }

    @GetMapping("/getall")
    public List<Booking> getAllBookings(HttpServletRequest request) {
        if (!authenticate(request)) {
            return null;
        }
        logger.info("Fetching all bookings");
        return service.getAllBookings();
    }
}
