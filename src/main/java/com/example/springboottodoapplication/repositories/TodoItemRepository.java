package com.example.springboottodoapplication.repositories;

import com.example.springboottodoapplication.entities.TodoItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TodoItemRepository extends JpaRepository<TodoItem, Long> {
}
