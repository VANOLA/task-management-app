package com.example.group1todoapplication.repositories;

import com.example.group1todoapplication.models.TodoItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * This interface extends JpaRepository and defines the interface between application and database
 */
@Repository
public interface TodoItemRepository extends JpaRepository<TodoItem, Long> {
}
