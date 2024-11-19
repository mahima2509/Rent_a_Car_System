package com.wipro.cabapi.entity;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "cab_info")
public class Cab {

    @Id
    private int cabId;
    private String cabName;
    private LocalDate dateOfBook;

    private int driverId;

    public Cab() {
        super();
    }

    public Cab(int cabId, String cabName, LocalDate dateOfBook, int driverId) {
        super();
        this.cabId = cabId;
        this.cabName = cabName;
        this.dateOfBook = dateOfBook;
        this.driverId = driverId;
    }

    public int getCabId() {
        return cabId;
    }

    public void setCabId(int cabId) {
        this.cabId = cabId;
    }

    public String getCabName() {
        return cabName;
    }

    public void setCabName(String cabName) {
        this.cabName = cabName;
    }

    public LocalDate getDateOfBook() {
        return dateOfBook;
    }

    public void setDateOfBook(LocalDate dateOfBook) {
        this.dateOfBook = dateOfBook;
    }

    public int getDriverId() {
        return driverId;
    }

    public void setDriverId(int driverId) {
        this.driverId = driverId;
    }
}
