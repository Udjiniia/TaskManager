package com.example.demo.service;

import com.example.demo.model.Task;
import com.example.demo.model.TaskPriority;
import com.example.demo.repos.TaskManagerRepoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TaskServiceCrud {
    private TaskManagerRepoImpl taskManagerRepoImpl;

    @Autowired
    public TaskServiceCrud(TaskManagerRepoImpl taskManagerRepoImpl) {
        this.taskManagerRepoImpl = taskManagerRepoImpl;
    }

    public boolean addTask(Task task){
        throw  new UnsupportedOperationException();
    }

    public List<Task> showAllTasks(){
        throw  new UnsupportedOperationException();
    }

    public Task showTask(Long id){
        throw  new UnsupportedOperationException();
    }

    public boolean deleteTask(Task task){
        throw  new UnsupportedOperationException();
    }

    public void setTaskId(Task task){
        throw  new UnsupportedOperationException();
    }

    public Task findTaskById(Long id){
        throw  new UnsupportedOperationException();
    }

    public boolean updateTask(Long id, Task task){throw  new UnsupportedOperationException();
    }


}
