package com.example.demo.service;

import com.example.demo.model.Task;

import java.util.Collection;

public interface TaskService {
    Task createTask(Task task);

    Collection<Task> getAllTasks();

    void deleteById(int id);

    void update(Task task, int id);

    Task getByPriority(int priority);

    Collection<Task> getByName(String name);

    Task getById(int id);
}
