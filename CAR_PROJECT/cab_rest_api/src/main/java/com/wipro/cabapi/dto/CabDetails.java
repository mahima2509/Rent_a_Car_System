package com.wipro.cabapi.dto;

public class CabDetails {
    private Long cabId;
    private String cabName;
    private String dateOfBook; // Keep as string for now, or you can change to LocalDate or another date type
    private Long driverId;
    private String driverName;
    private Object driverRating; // Adjust the type based on your actual rating system (e.g., Integer, Double, etc.)

    // Private constructor for Builder
    private CabDetails(Builder builder) {
        this.cabId = builder.cabId;
        this.cabName = builder.cabName;
        this.dateOfBook = builder.dateOfBook;
        this.driverId = builder.driverId;
        this.driverName = builder.driverName;
        this.driverRating = builder.driverRating;
    }

    // Getters
    public Long getCabId() {
        return cabId;
    }

    public String getCabName() {
        return cabName;
    }

    public String getDateOfBook() {
        return dateOfBook;
    }

    public Long getDriverId() {
        return driverId;
    }

    public String getDriverName() {
        return driverName;
    }

    public Object getDriverRating() {
        return driverRating;
    }

    // Static inner Builder class
    public static class Builder {
        private Long cabId;
        private String cabName;
        private String dateOfBook;
        private Long driverId;
        private String driverName;
        private Object driverRating;

        // Builder methods for setting each field
        public Builder cabId(Long cabId) {
            this.cabId = cabId;
            return this;
        }

        public Builder cabName(String cabName) {
            this.cabName = cabName;
            return this;
        }

        public Builder dateOfBook(String dateOfBook) {
            this.dateOfBook = dateOfBook;
            return this;
        }

        public Builder driverId(Long driverId) {
            this.driverId = driverId;
            return this;
        }

        public Builder driverName(String driverName) {
            this.driverName = driverName;
            return this;
        }

        public Builder driverRating(Object driverRating) {
            this.driverRating = driverRating;
            return this;
        }

        // Build method to create the CabDetails instance
        public CabDetails build() {
            return new CabDetails(this);
        }
    }
}
