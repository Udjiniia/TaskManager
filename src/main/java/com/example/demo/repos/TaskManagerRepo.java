package com.example.demo.repos;

import com.example.demo.model.Task;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class TaskManagerRepo{
    private List<Task> tasksList;

    public TaskManagerRepo(){
        this.tasksList = new ArrayList<>();
    }

    public void addTask(Task task){
        tasksList.add(task);
    }

    public List<Task> showTasks(){
        return tasksList;
    }

    public void deleteTask(Task task){
        tasksList.remove(task);
    }
}
