package com.example.demo.repos;

import com.example.demo.model.Task;

import java.util.Collection;
import java.util.List;

public interface TaskManagerRepo {
    Collection<Task> getAllTasks();
    int createTask(Task task);
    void update(Task task, int id);
    void deleteById(int id);
    Task getByPriority(int priority);
    int countByPriority(int priority);
    Collection<Task> getByName(String name);
    Task getByID(int id);
}
