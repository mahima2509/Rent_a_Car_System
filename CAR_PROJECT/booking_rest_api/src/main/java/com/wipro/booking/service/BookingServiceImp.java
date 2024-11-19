package com.wipro.booking.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wipro.booking.dto.BookingDTO;
import com.wipro.booking.entity.Booking;
import com.wipro.booking.repository.BookingRepository;

@Service
public class BookingServiceImp implements IBookingService {

    @Autowired
    BookingRepository repo;

    Logger logger = LoggerFactory.getLogger(BookingServiceImp.class);

    @Override
    public Booking addBooking(BookingDTO bookingDTO) {
        Booking booking = new Booking();
        
        booking.setCabName(bookingDTO.getCabName());
        booking.setStartLocation(bookingDTO.getStartLocation());
        booking.setEndLocation(bookingDTO.getEndLocation());
        booking.setTripDate(bookingDTO.getTripDate()); // Convert tripDate string to Date if necessary
        booking.setDuration(bookingDTO.getDuration());
        //booking.setTotalPrice(bookingDTO.getTotalPrice());

        return repo.save(booking);
    }

    @Override
    public BookingDTO getById(int bookingId) {
        Booking booking = repo.findById(bookingId).orElseThrow(() -> new RuntimeException("Booking not found"));

        BookingDTO bookingDTO = new BookingDTO();
        bookingDTO.setBookingId(booking.getBookingId());
        bookingDTO.setCabName(booking.getCabName());
        bookingDTO.setStartLocation(booking.getStartLocation());
        bookingDTO.setEndLocation(booking.getEndLocation());
        bookingDTO.setTripDate(booking.getTripDate()); // Convert Date to string if needed
        bookingDTO.setDuration(booking.getDuration());
      //  bookingDTO.setTotalPrice(booking.getTotalPrice());
        
        return bookingDTO;
    }

    @Override
    public List<Booking> getAllBookings() {
        logger.info("Fetching all bookings from service class");
        return repo.findAll();
    }

    @Override
    public Booking updateBooking(BookingDTO bookingDTO) {
        Booking booking = new Booking();

        booking.setBookingId(bookingDTO.getBookingId());
        booking.setCabName(bookingDTO.getCabName());
        booking.setStartLocation(bookingDTO.getStartLocation());
        booking.setEndLocation(bookingDTO.getEndLocation());
        booking.setTripDate(bookingDTO.getTripDate()); // Convert tripDate string to Date if necessary
        booking.setDuration(bookingDTO.getDuration());
        //booking.setTotalPrice(bookingDTO.getTotalPrice());

        return repo.save(booking);
    }

    @Override
    public void deleteById(int bookingId) {
        Booking booking = repo.findById(bookingId)
                .orElseThrow(() -> new RuntimeException("Booking with ID " + bookingId + " not found."));
        repo.delete(booking);
        System.out.println("Booking with ID " + bookingId + " deleted successfully.");
    }
}
