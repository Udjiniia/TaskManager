package com.example.demo.service;

import com.example.demo.model.Task;

import java.util.Collection;

public interface TaskService {
    public int createTask(Task task);
    public Collection<Task> getAllTasks();
    public void deleteById(int id);
    public void update(Task task, int id);
    Task getByPriority(int priority);
    Collection<Task> getByName(String name);
    Task getById(int id);
}
