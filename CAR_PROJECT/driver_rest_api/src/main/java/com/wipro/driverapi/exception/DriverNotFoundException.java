package com.wipro.driverapi.exception;

import org.springframework.http.HttpStatusCode;
import org.springframework.web.server.ResponseStatusException;

public class DriverNotFoundException extends ResponseStatusException {

    public DriverNotFoundException(HttpStatusCode status, String msg) {
        super(status, msg);
    }

}
