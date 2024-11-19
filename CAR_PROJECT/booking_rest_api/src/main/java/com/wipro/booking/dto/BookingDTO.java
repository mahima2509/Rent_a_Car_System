package com.wipro.booking.dto;

import java.time.LocalDate;

public class BookingDTO {
    
    private Integer bookingId;
    private String cabName;
    private String startLocation;
    private String endLocation;
    private LocalDate tripDate; // Consider changing to a Date type if needed
    private String duration;
   // private Double totalPrice;

    // Getters and Setters
    public Integer getBookingId() {
        return bookingId;
    }

    public void setBookingId(Integer bookingId) {
        this.bookingId = bookingId;
    }

    public String getCabName() {
        return cabName;
    }

    public void setCabName(String cabName) {
        this.cabName = cabName;
    }

    public String getStartLocation() {
        return startLocation;
    }

    public void setStartLocation(String startLocation) {
        this.startLocation = startLocation;
    }

    public String getEndLocation() {
        return endLocation;
    }

    public void setEndLocation(String endLocation) {
        this.endLocation = endLocation;
    }

    public LocalDate getTripDate() {
        return tripDate;
    }

    public void setTripDate(LocalDate tripDate) {
        this.tripDate = tripDate;
    }
	/*
	 * public LocalDate getDateOfBook() { return dateOfBook; }
	 * 
	 * public void setDateOfBook(LocalDate dateOfBook) { this.dateOfBook =
	 * dateOfBook; }
	 */

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

	/*
	 * public Double getTotalPrice() { return totalPrice; }
	 * 
	 * public void setTotalPrice(Double totalPrice) { this.totalPrice = totalPrice;
	 * }
	 */
}
