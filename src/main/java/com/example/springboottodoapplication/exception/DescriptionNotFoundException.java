package com.example.springboottodoapplication.exception;

public class DescriptionNotFoundException extends RuntimeException {
    public DescriptionNotFoundException() {
        super("Description is required");
    }
}
