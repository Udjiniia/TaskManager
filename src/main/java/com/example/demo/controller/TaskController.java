package com.example.demo.controller;

import com.example.demo.model.Task;
import com.example.demo.model.TaskDate;
import com.example.demo.model.TaskPriority;
import com.example.demo.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;


@Controller
public class TaskController {

    private TaskService taskService;

    @Autowired
    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping("/add_task")
    public String getPage(){
        return "add_task";
    }

    @GetMapping("/tasks")
    public String getTasks(Model model) {
        model.addAttribute("listOfTasks", taskService.showTasks());
        return "tasks";
    }
    @PostMapping("/add_task")
    public String addTask(@RequestParam String taskName, @RequestParam int taskPriority, @RequestParam String taskDate,
                          @RequestParam boolean taskStatus) throws ParseException {
        Task task = new Task(taskName, new TaskPriority(taskPriority), new TaskDate(taskDate), taskStatus);
        taskService.addTask(task);
        taskService.setTaskId(task);
        return "add_task";
    }

    //ДЕНИС ДОДЕЛАЙ ЭТУ ХУЕТУ ПЖШКА *__* =*** <3
//    @DeleteMapping("/tasks/{id}")
//    public String deleteTask(@PathVariable(value = "id") Long taskId){
//        Task task = taskService.findTaskById(taskId);
//        System.out.println(task.getTaskName());
//        taskService.deleteTask(task);
//        return "redirect:/tasks";
//    }
}
