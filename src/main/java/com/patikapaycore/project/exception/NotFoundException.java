package com.patikapaycore.project.exception;

public class NotFoundException extends RuntimeException {

    public NotFoundException(String message) {
        super(message + " Not found exception");
    }
}

