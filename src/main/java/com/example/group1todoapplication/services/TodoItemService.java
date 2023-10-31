package com.example.group1todoapplication.services;

import com.example.group1todoapplication.models.TodoItem;
import com.example.group1todoapplication.repositories.TodoItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.Optional;

/**
 * This service contains the implementation of the findById method. It uses
 * the repository to retrieve, delete, or create tasks in the database.
 */
@Service
public class TodoItemService {

    // pull in todoItemRepository
    @Autowired
    private TodoItemRepository todoItemRepository;

    public Iterable<TodoItem> getAll() {
        return todoItemRepository.findAll();
    }

    /**
     * Returns optional task
     * @param id
     * @return optional task
     */
    public Optional<TodoItem> getbyId(Long id) {
        return todoItemRepository.findById(id);
    }

    /**
     * Saves a task to the database and updates it.
     * @param todoItem
     * @return Todo Item
     */
    public TodoItem save(TodoItem todoItem) {
        // checks if task is in database. If not, it creates it.
        if (todoItem.getId() == null) {
            todoItem.setCreatedAt(Instant.now());
        }

        // updates task
        todoItem.setUpdatedAt(Instant.now());
        return  todoItemRepository.save(todoItem);
    }

    /**
     * Deletes a task from the database
     * @param todoItem
     */
    public void delete(TodoItem todoItem) {
        todoItemRepository.delete(todoItem);
    }
}
