package com.example.demo.controller;

import com.example.demo.model.Task;
import com.example.demo.service.TaskServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@RestController
public class TaskControllerCrud {

    private final TaskServiceImpl taskServiceImpl;


    @Autowired
    public TaskControllerCrud(TaskServiceImpl taskServiceImpl) {
        this.taskServiceImpl = taskServiceImpl;
    }

    @GetMapping(value = "/tasks")
    public ResponseEntity<List<Task>> getAllTasks() {
        final List<Task> tasks = new ArrayList<>(taskServiceImpl.getAllTasks());
        return !tasks.isEmpty() ? new ResponseEntity<>(tasks, HttpStatus.OK) :
                new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping(value = "/tasks/{id}")
    public ResponseEntity<Task> showTask(@PathVariable(name = "id") int id) {
        Task task = taskServiceImpl.getById(id);
        return task != null ? new ResponseEntity<>(task, HttpStatus.OK) :
                new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping(value = "/add_task")
    public ResponseEntity<?> addTask(@RequestBody Task task) {
        int lastId = taskServiceImpl.createTask(task);
        return new ResponseEntity<>(lastId, HttpStatus.CREATED);
    }

    @DeleteMapping(value = "delete/{id}")
    public ResponseEntity<?> deleteTask(@PathVariable(name = "id") int id) {
        taskServiceImpl.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping(value = "update/{id}")
    public ResponseEntity<Task> updateTask(@PathVariable(name = "id") int id, @RequestBody Task task) {
        taskServiceImpl.update(task, id);
        Task oldTask = taskServiceImpl.getById(id);
        return oldTask != task ? new ResponseEntity<>(task, HttpStatus.OK) :
                new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }
}
