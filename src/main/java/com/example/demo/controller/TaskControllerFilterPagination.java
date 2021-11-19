package com.example.demo.controller;

import com.example.demo.model.Task;
import com.example.demo.service.TaskServiceCrud;
import com.example.demo.service.TaskServiceFilterPagination;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TaskControllerFilterPagination {

    private final TaskServiceFilterPagination taskServiceFilterPagination;


    @Autowired
    public TaskControllerFilterPagination(TaskServiceFilterPagination taskServiceFilterPagination) {
        this.taskServiceFilterPagination = taskServiceFilterPagination;
    }

    @GetMapping(value = "/filter/priority")
    public ResponseEntity<List<Task>> filterByPriority(@RequestParam int priority){
        final List<Task> tasks = taskServiceFilterPagination.filterByPriority(priority);
        return !tasks.isEmpty()? new ResponseEntity<>(tasks, HttpStatus.OK) :
                new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping(value = "/filter/name")
    public ResponseEntity<List<Task>> filterByPriority(@RequestParam String name){
        final List<Task> tasks = taskServiceFilterPagination.filterByName(name);
        return !tasks.isEmpty()? new ResponseEntity<>(tasks, HttpStatus.OK) :
                new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping(value = "/filter/status")
    public ResponseEntity<List<Task>> filterByPriority(@RequestParam boolean isDone){
        final List<Task> tasks = taskServiceFilterPagination.filterByStatus(isDone);
        return !tasks.isEmpty()? new ResponseEntity<>(tasks, HttpStatus.OK) :
                new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping(value = "/tasks-paginated")
    public ResponseEntity<List<Task>> showAllTasksPaginated(@RequestParam int size, @RequestParam int page){
        final List<Task> tasks = taskServiceFilterPagination.showAllTasksPaginated(size, page);
        return !tasks.isEmpty() ? new ResponseEntity<>(tasks, HttpStatus.OK) :
                new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
