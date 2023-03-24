package com.OnlineBookStore.BookStore.exception;

public class OrderNotFoundException extends RuntimeException {
    public OrderNotFoundException(String id) {
        super("Could not find order " + id);
    }
}