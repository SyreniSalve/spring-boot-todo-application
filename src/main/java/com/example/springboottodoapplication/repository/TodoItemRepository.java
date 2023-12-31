package com.example.springboottodoapplication.repository;

import com.example.springboottodoapplication.entitiy.TodoItemEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TodoItemRepository extends JpaRepository<TodoItemEntity, Long> {
}
