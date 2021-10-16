package com.example.demo.controller;

import com.example.demo.model.Task;
import com.example.demo.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@Controller
public class TaskController {

    TaskService taskService;
    List<Task> listOfTasks;

    @Autowired
    public TaskController(TaskService taskService, List<Task> listOfTasks) {
        this.taskService = taskService;
        this.listOfTasks = listOfTasks;
    }

    @GetMapping("/tasks")
    public String getTasks(Model model) {
        listOfTasks = taskService.getTasks();
        model.addAttribute("listOfTasks", listOfTasks);
        return "tasks";
    }



}
