package com.example.group1todoapplication.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.group1todoapplication.services.TodoItemService;

/**
 * This controller provides access to the applications home page. It interprets
 * user input and transforms it into a model that is represented to the user
 * by the view
 * asdfasd
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
     * @return returns model and view
     */

     /*
      * This method will return the login.html
      */
    @GetMapping("/")
    public ModelAndView index() {
        ModelAndView modelAndView = new ModelAndView("login");
        modelAndView.addObject("todoItems", todoItemService.getAll());
        return modelAndView;
    }
    
    /**
     * This method will return the dashboard.html
     */
    @GetMapping("/dashboard")
    public ModelAndView trackIt() {
        ModelAndView modelAndView = new ModelAndView("dashboard");
        return modelAndView;
    }

    /**
     * This method will return the dashboard.html
     */
    @GetMapping("/logout")
    public ModelAndView logout() {
        ModelAndView modelAndView = new ModelAndView("logout");
        return modelAndView;
    }
}
