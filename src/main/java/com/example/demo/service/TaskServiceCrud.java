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
        return taskManagerRepoImpl.addTask(task);
    }

    public List<Task> showAllTasks(){
        return taskManagerRepoImpl.showAllTasks();
    }

    public Task showTask(Long id){
        return taskManagerRepoImpl.showTask(id);
    }

    public boolean deleteTask(Task task){
        return taskManagerRepoImpl.deleteTask(task);
    }

    public void setTaskId(Task task){
        task.setId();
    }

    public Task findTaskById(Long id){
        return taskManagerRepoImpl.showTask(id);
    }

    public boolean updateTask(Long id, Task task){
        return taskManagerRepoImpl.updateTask(id, task);
    }


}
