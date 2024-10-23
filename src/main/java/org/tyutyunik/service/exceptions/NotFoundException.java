package org.tyutyunik.service.exceptions;

public class NotFoundException extends RuntimeException {
    public NotFoundException() {
        super("[EXCEPTION] Not Found");
    }
}
