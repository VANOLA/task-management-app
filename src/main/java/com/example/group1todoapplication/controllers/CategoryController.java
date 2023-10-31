package com.example.group1todoapplication.controllers;

import org.springframework.ui.Model;
import com.example.group1todoapplication.models.TodoItem;
import com.example.group1todoapplication.services.TodoItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

//TODO change this so that the user can select from a list of categories they entered
@Controller
public class CategoryController {
    @Autowired
    private TodoItemService todoItemService;

    @GetMapping("/categories")
    public String showSortByCategoryPage(Model model) {
        List<TodoItem> todoItems = StreamSupport.stream(todoItemService.getAll().spliterator(),
                false).collect(Collectors.toList());
        todoItems.sort(Comparator.comparing(TodoItem::getTaskCategory));

        model.addAttribute("todoItems", todoItems);
        return "categories";
    }
}
