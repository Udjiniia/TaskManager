package com.example.demo.controller;
import com.example.demo.model.Task;
import com.example.demo.service.TaskServiceCrud;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class TaskControllerCrud {

    private final TaskServiceCrud taskServiceCrud;


    @Autowired
    public TaskControllerCrud(TaskServiceCrud taskServiceCrud) {
        this.taskServiceCrud = taskServiceCrud;
    }

    @GetMapping(value = "/tasks")
    public ResponseEntity<List<Task>> getAllTasks(){
        final List<Task> tasks = taskServiceCrud.showAllTasks();
        return !tasks.isEmpty() ? new ResponseEntity<>(tasks, HttpStatus.OK) :
                new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping(value = "/tasks/{id}")
    public ResponseEntity<Task> showTask(@PathVariable(name = "id") Long id){
        Task task = taskServiceCrud.showTask(id);
        return task!=null ? new ResponseEntity<>(task, HttpStatus.OK) :
                new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping(value = "/add_task")
    public ResponseEntity<?> addTask(@RequestBody Task task){
        boolean added = taskServiceCrud.addTask(task);
        taskServiceCrud.setTaskId(task);
        return added? new ResponseEntity<>(HttpStatus.CREATED) :
                new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }

    @DeleteMapping(value = "delete/{id}")
    public ResponseEntity<?> deleteTask(@PathVariable(name = "id") Long id){
        Task task = taskServiceCrud.findTaskById(id);
        boolean deleted = taskServiceCrud.deleteTask(task);
        return deleted ? new ResponseEntity<>(HttpStatus.OK) :
                new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }

    @PutMapping(value = "update/{id}")
    public ResponseEntity<Task> updateTask(@PathVariable(name = "id") Long id, @RequestBody Task task){
        boolean updated = taskServiceCrud.updateTask(id, task);
        return updated? new ResponseEntity<>(task, HttpStatus.OK) :
                new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }
}
