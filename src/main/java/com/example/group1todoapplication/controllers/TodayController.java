package com.example.group1todoapplication.controllers;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.group1todoapplication.models.TodoItem;
import com.example.group1todoapplication.services.TodoItemService;


@Controller
public class TodayController {
     @Autowired
    private TodoItemService todoItemService;

    @GetMapping("/today")
    public String showSortByCategoryPage(Model model) {
        List<TodoItem> todoItems = StreamSupport.stream(todoItemService.getAll().spliterator(),
                false).collect(Collectors.toList());
        todoItems.sort(Comparator.comparing(TodoItem::getTaskCategory));

        model.addAttribute("todoItems", todoItems);
        return "today";
    }
}
