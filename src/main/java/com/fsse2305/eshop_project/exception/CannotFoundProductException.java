package com.fsse2305.eshop_project.exception;

public class CannotFoundProductException extends RuntimeException{
    public CannotFoundProductException(String message) {
        super(message);
    }
}
