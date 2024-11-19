package com.wipro.cabapi.dto;

public class CabDriverVO {

    private CabDTO cab;
    private Driver driver;

    public CabDriverVO() {

    }

    public CabDriverVO(CabDTO cab, Driver driver) {
        super();
        this.cab = cab;
        this.driver = driver;
    }

    public CabDTO getCab() {
        return cab;
    }

    public void setCab(CabDTO cab) {
        this.cab = cab;
    }

    public Driver getDriver() {
        return driver;
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
    }
}
