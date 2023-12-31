package com.example.springboottodoapplication.controller;

import com.example.springboottodoapplication.entitiy.TodoItemEntity;
import com.example.springboottodoapplication.service.TodoItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin("http://localhost:3000")
public class TodoItemController {
    @Autowired
    private TodoItemService todoItemService;

    @GetMapping("/todo/list")
    public ResponseEntity<List<TodoItemEntity>> findListOfAllTodoItemEntities() {
        return new ResponseEntity<>(this.todoItemService.findListOfAllTodoItemEntities(), HttpStatus.OK);
    }

    @GetMapping("/todo/{id}")
    public ResponseEntity<Optional<TodoItemEntity>> findTodoItemEntityById(@PathVariable Long id) {
        Optional<TodoItemEntity> todoItemEntity = this.todoItemService.findTodoItemEntityById(id);
        return new ResponseEntity<>(todoItemEntity, HttpStatus.OK);
    }

    @PostMapping("/todo")
    public ResponseEntity<TodoItemEntity> createNewTodoItemEntity(@RequestBody TodoItemEntity todoItemEntity) {
        TodoItemEntity newTodoItemEntity = this.todoItemService.createNewTodoItemEntity(todoItemEntity);
        return new ResponseEntity<>(newTodoItemEntity, HttpStatus.CREATED);
    }

    @PutMapping("/todo/{id}")
    public ResponseEntity<TodoItemEntity> updateTodoItemEntity(@RequestBody TodoItemEntity todoItemEntity,
                                                               @PathVariable long id) {
        TodoItemEntity newTodoItemEntity = this.todoItemService.updateTodoItemEntity(todoItemEntity, id);
        return new ResponseEntity<>(newTodoItemEntity, HttpStatus.OK);
    }

    @DeleteMapping("/todo/{id}")
    public ResponseEntity<String> deleteTodoItemEntity(@PathVariable Long id) {
        return new ResponseEntity<>(this.todoItemService.deleteTodoItemEntity(id), HttpStatus.OK);
    }
}
