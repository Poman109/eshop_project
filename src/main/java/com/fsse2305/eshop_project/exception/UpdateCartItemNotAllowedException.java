package com.fsse2305.eshop_project.exception;

public class UpdateCartItemNotAllowedException extends RuntimeException{
    public UpdateCartItemNotAllowedException(String message) {
        super(message);
    }
}
