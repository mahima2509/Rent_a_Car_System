package com.wipro.driverapi.dto;

public class DriverDTO {

    private int driverId;
    private String driverName;
    private double fare;
    private double rating; // Added rating field

    public int getDriverId() {
        return driverId;
    }

    public void setDriverId(int driverId) {
        this.driverId = driverId;
    }

    public String getDriverName() {
        return driverName;
    }

    public void setDriverName(String driverName) {
        this.driverName = driverName;
    }

    public double getFare() {
        return fare;
    }

    public void setFare(double fare) {
        this.fare = fare;
    }

    public double getRating() { // Getter for rating
        return rating;
    }

    public void setRating(double rating) { // Setter for rating
        this.rating = rating;
    }
}
