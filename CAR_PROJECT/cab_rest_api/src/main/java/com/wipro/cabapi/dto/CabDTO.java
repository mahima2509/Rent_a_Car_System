package com.wipro.cabapi.dto;

import java.time.LocalDate;

public class CabDTO {

    private int cabId;
    private String cabName;
    private LocalDate dateOfBook;
    private int driverId;

    public CabDTO() {
        super();
    }

    public CabDTO(int cabId, String cabName, LocalDate dateOfBook, int driverId) {
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
