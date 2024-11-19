package com.wipro.booking.service;

import java.util.List;

import com.wipro.booking.dto.BookingDTO;
import com.wipro.booking.entity.Booking;

public interface IBookingService {

    public Booking addBooking(BookingDTO bookingDTO);
    
    public BookingDTO getById(int bookingId);
    
    public List<Booking> getAllBookings();
    
    public Booking updateBooking(BookingDTO bookingDTO);

    public void deleteById(int bookingId);
}
