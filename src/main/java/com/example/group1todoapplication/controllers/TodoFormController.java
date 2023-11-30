package com.example.group1todoapplication.controllers;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.group1todoapplication.models.TodoItem;
import com.example.group1todoapplication.services.TodoItemService;

import jakarta.validation.Valid;

/**
 * This controller provides access to the application form page. It interprets user
 * input and transforms it into a model that is represented to the user
 * by the view
 */
@Controller
public class TodoFormController {
    @Autowired
    private TodoItemService todoItemService;

    @GetMapping("/create-todo")
    public String showCreateForm(TodoItem todoItem) {
        return "new-todo-item";
    }

    /**
     * Captures the todo item from the new-todo-item.html form
     * @param todoItem
     * @param result
     * @param model
     * @return
     */
    @PostMapping("/todo")
    public String createTodoItem(@Valid TodoItem todoItem, BindingResult result, Model model) {
        TodoItem item = new TodoItem();
        item.setTaskName(todoItem.getTaskName());
        item.setDescription(todoItem.getDescription());
        item.setPriorityLevel(todoItem.getPriorityLevel());
        // convert local date to string before saving
        String dueDateString = todoItem.getDueDate().toString();
        item.setDueDate(LocalDate.parse(dueDateString));
        item.setTaskCategory(todoItem.getTaskCategory());
        item.setIsComplete(todoItem.getIsComplete());

        // save and return to the root path
        todoItemService.save(todoItem);
        return "redirect:/dashboard";
    }

    @GetMapping("/delete/{id}")
    public String deleteTodoItem(@PathVariable("id") Long id, Model model) {
        TodoItem todoItem = todoItemService.getbyId(id)
                .orElseThrow(() -> new IllegalArgumentException("TodoItem id: " + id + "not found"));
        todoItemService.delete(todoItem);
        return "redirect:/dashboard";
    }

    @GetMapping("/edit/{id}")
    public String showUpdateForm(@PathVariable("id") Long id, Model model) {
        TodoItem todoItem = todoItemService.getbyId(id)
                .orElseThrow(() -> new IllegalArgumentException("TodoItem id: " + id + " not found"));

        model.addAttribute("todo", todoItem);
        return "edit-todo-item";
    }

    @PostMapping("/todo/{id}")
    public String updateTodoItem(@PathVariable("id") Long id, @Valid TodoItem todoItem, BindingResult result, Model model) {

        TodoItem item = todoItemService.getbyId(id)
                .orElseThrow(() -> new IllegalArgumentException("TodoItem id: " + id + " not found"));

        item.setTaskName(todoItem.getTaskName());
        item.setIsComplete(todoItem.getIsComplete());
        item.setDescription(todoItem.getDescription());
        item.setPriorityLevel(todoItem.getPriorityLevel());
        item.setTaskCategory(todoItem.getTaskCategory());

        todoItemService.save(item);

        return "redirect:/dashboard";
    }
}