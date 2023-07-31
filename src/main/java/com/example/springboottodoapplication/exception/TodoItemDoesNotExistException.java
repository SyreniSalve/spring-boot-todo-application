package com.example.springboottodoapplication.exception;

public class TodoItemDoesNotExistException extends RuntimeException {
    public TodoItemDoesNotExistException(Long id) {
        super(String.format("Todo item with id %d does not exist", id));
    }
}
