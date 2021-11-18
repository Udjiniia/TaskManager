package com.example.demo.repos;

import com.example.demo.model.Task;
import org.springframework.stereotype.Repository;

import java.util.*;
import java.util.logging.LogManager;
import java.util.stream.Collectors;

@Repository
public class TaskManagerRepoImpl implements TaskManagerRepo{
    private Map<Long, Task> tasksList;

    public TaskManagerRepoImpl(){
        this.tasksList = new HashMap<>();
    }

    @Override
    public List<Task> showAllTasks() {
        return new ArrayList<Task>(tasksList.values());
    }

    @Override
    public Task showTask(Long id) {
        return tasksList.get(id);
    }

    @Override
    public boolean addTask(Task task){
        tasksList.put(Task.getCounter(), task);
        return true;
    }

    @Override
    public boolean deleteTask(Task task){
        tasksList.remove(task.getId());
        return true;
    }

    @Override
    public boolean updateTask(Long id, Task task) {
        if (tasksList.containsKey(id)){
            task.setId(id);
            tasksList.put(id, task);
            return true;
        }
        return false;
    }
}
