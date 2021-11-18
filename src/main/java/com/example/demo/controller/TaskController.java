package com.example.demo.controller;

import com.example.demo.model.Task;
import com.example.demo.model.TaskDate;
import com.example.demo.model.TaskPriority;
import com.example.demo.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.List;

@RestController
public class TaskController {

    private final TaskService taskService;

    @Autowired
    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping(value = "/tasks")
    public ResponseEntity<List<Task>> getAllTasks(){
        final List<Task> tasks = taskService.showAllTasks();
        return !tasks.isEmpty() ? new ResponseEntity<>(tasks, HttpStatus.OK) :
                new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping(value = "/tasks/{id}")
    public ResponseEntity<Task> showTask(@PathVariable(name = "id") Long id){
        Task task = taskService.showTask(id);
        return task!=null ? new ResponseEntity<>(task, HttpStatus.OK) :
                new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping(value = "/add_task")
    public ResponseEntity<?> addTask(@RequestBody Task task){
        boolean added = taskService.addTask(task);
        taskService.setTaskId(task);
        return added? new ResponseEntity<>(HttpStatus.CREATED) :
                new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }

    @DeleteMapping(value = "delete/{id}")
    public ResponseEntity<?> deleteTask(@PathVariable(name = "id") Long id){
        Task task = taskService.findTaskById(id);
        boolean deleted = taskService.deleteTask(task);
        return deleted ? new ResponseEntity<>(HttpStatus.OK) :
                new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }

    @PostMapping(value = "update/{id}")
    public ResponseEntity<Task> updateTask(@PathVariable(name = "id") Long id, @RequestBody Task task){
        boolean updated = taskService.updateTask(id, task);
        return updated? new ResponseEntity<>(task, HttpStatus.OK) :
                new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }

    @PostMapping(value = "filter/{priority}")
    public ResponseEntity<List<Task>> filterByPriority(@PathVariable(name = "priority") int priority){
        final List<Task> tasks = taskService.filterByPriority(priority);
        return !tasks.isEmpty()? new ResponseEntity<>(tasks, HttpStatus.OK) :
                new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
