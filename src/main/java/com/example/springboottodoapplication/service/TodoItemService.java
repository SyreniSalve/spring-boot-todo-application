package com.example.springboottodoapplication.service;


import com.example.springboottodoapplication.entitiy.TodoItemEntity;
import com.example.springboottodoapplication.exception.DescriptionNotFoundException;
import com.example.springboottodoapplication.exception.TodoItemDoesNotExistException;
import com.example.springboottodoapplication.exception.TodoListIsEmptyException;
import com.example.springboottodoapplication.repository.TodoItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TodoItemService {

    @Autowired
    private TodoItemRepository todoItemRepository;


    public List<TodoItemEntity> findListOfAllTodoItemEntities() {
        List<TodoItemEntity> todoItemEntityList = this.todoItemRepository.findAll();
        if (todoItemEntityList.isEmpty()) {
            throw new TodoListIsEmptyException();
        }
        return this.todoItemRepository.findAll();
    }

    public Optional<TodoItemEntity> findTodoItemEntityById(Long id) {
        return Optional.ofNullable(this.todoItemRepository.findById(id)
                .orElseThrow(() -> new TodoItemDoesNotExistException(id)));
    }

    public TodoItemEntity createNewTodoItemEntity(TodoItemEntity newTodoItemEntity) {
        newTodoItemEntity.setComplete(false);
        if (newTodoItemEntity.getDescription() == null
                || newTodoItemEntity.getDescription().isEmpty()
                || newTodoItemEntity.getDescription().isBlank()) {
            throw new DescriptionNotFoundException();
        } else {
            return this.todoItemRepository.save(newTodoItemEntity);
        }
    }

    public TodoItemEntity updateTodoItemEntity(TodoItemEntity newTodoItemEntity, Long id) {
        if (newTodoItemEntity.isComplete()
                || newTodoItemEntity.getDescription() == null
                || newTodoItemEntity.getDescription().isEmpty()
                || newTodoItemEntity.getDescription().isBlank()) {
            return this.todoItemRepository.findById(id)
                    .map(user -> {
                        user.setComplete(newTodoItemEntity.isComplete());
                        return this.todoItemRepository.save(user);
                    }).orElseThrow(() -> new TodoItemDoesNotExistException(id));
        }
        return this.todoItemRepository.findById(id)
                .map(user -> {
                    user.setDescription(newTodoItemEntity.getDescription());
                    return this.todoItemRepository.save(user);
                }).orElseThrow(() -> new TodoItemDoesNotExistException(id));
    }

    public String deleteTodoItemEntity(Long id) {
        if (!this.todoItemRepository.existsById(id)) {
            throw new TodoItemDoesNotExistException(id);
        }
        this.todoItemRepository.deleteById(id);
        return String.format("Todo item with id %d successfully deleted", id);
    }
}
