package com.example.springboottodoapplication.controllers;

import com.example.springboottodoapplication.entities.TodoItem;
import com.example.springboottodoapplication.repositories.TodoItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TodoItemController {

    @Autowired
    private TodoItemRepository todoItemRepository;

    @PostMapping("/todo")
    ResponseEntity<TodoItem> newTodoItem(@RequestBody TodoItem newTodoItem) {
        TodoItem postResponse = todoItemRepository.save(newTodoItem);
        return new ResponseEntity<>(postResponse, HttpStatus.CREATED);
    }
}
