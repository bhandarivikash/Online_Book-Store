package com.OnlineBookStore.BookStore.exception;

public class NotFoundException extends Throwable {

    public NotFoundException(String id) {
        super("User not found with username: " + id);
    }
}