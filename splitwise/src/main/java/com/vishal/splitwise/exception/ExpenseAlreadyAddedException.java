package com.vishal.splitwise.exception;

public class ExpenseAlreadyAddedException extends RuntimeException {
    public ExpenseAlreadyAddedException(String message) {
        super(message);
    }
}
