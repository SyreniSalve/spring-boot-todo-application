package com.example.springboottodoapplication.exception;

public class TodoListIsEmptyException extends RuntimeException{

    public TodoListIsEmptyException() {
        super("Todo list is empty");
    }
}
