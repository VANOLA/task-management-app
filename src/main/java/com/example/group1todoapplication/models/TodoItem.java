package com.example.group1todoapplication.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.Instant;
import java.time.LocalDate;

/**
 * This class extends Serializable and represents a task object
 */
@Getter
@Setter
@Entity
@Table(name = "todo_items")
public class TodoItem implements Serializable {

    // Define what type of sequence used to generate ids
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    // task name
    private String taskName;

    // description of task
    private String description;

    // task priority
    private String priorityLevel;

    // due date
    private LocalDate dueDate;

    // task category
    private String taskCategory;

    // mark task completed
    private Boolean isComplete;

    // track when task is created
    private Instant createdAt;

    // track when task is updated
    private Instant updatedAt;

    @Override
    public String toString() {
        return String.format("TodoItem{id=%d, taskName='%s', description='%s', priorityLevel='%s', dueDate='%s'," +
                        "taskCategory='%s', isComplete='%s', createdAt='%s', updatedAt='%s'}",
                id, taskName, description, priorityLevel, dueDate, taskCategory, isComplete, createdAt, updatedAt);
    }
}
