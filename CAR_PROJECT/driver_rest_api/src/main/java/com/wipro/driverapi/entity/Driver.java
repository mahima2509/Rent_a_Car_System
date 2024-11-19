package com.wipro.driverapi.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Driver {  // Driver Entity class 
	
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
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

    @Override
    public String toString() {
        return "Driver [driverId=" + driverId + ", driverName=" + driverName + ", fare=" + fare + ", rating=" + rating + "]";
    }
}
