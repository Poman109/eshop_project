package com.fsse2305.eshop_project.exception;

public class TransactionNotAllowException extends RuntimeException{
    public TransactionNotAllowException(String message) {
        super(message);
    }
}
