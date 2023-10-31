package com.example.group1todoapplication.controllers;

import com.example.group1todoapplication.services.TodoItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * This controller provides access to the applications home page. It interprets
 * user input and transforms it into a model that is represented to the user
 * by the view
 */
@Controller
public class HomeController {

    // pull in our todoItemService
    @Autowired
    private TodoItemService todoItemService;

    /**
     * Handler method gets task from the service and passes it to the
     * ModelAndView object. It assigns it a key, and makes it available
     * to the index.html file.
     * @return
     */
    @GetMapping("/")
    public ModelAndView index() {
        ModelAndView modelAndView = new ModelAndView("index");
        modelAndView.addObject("todoItems", todoItemService.getAll());
        return modelAndView;
    }
}
