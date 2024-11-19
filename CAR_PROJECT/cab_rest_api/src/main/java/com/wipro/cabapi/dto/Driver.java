package com.wipro.cabapi.dto;

public class Driver { // POJO

    private int driverId;
    private String driverName;
    private double rating;
    private double fare;

    public Driver() {

    }

    public Driver(int driverId, String driverName, double rating, double fare) {
        super();
        this.driverId = driverId;
        this.driverName = driverName;
        this.rating = rating;
        this.fare = fare;
    }

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

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public double getFare() {
        return fare;
    }

    public void setFare(double fare) {
        this.fare = fare;
    }
}
