package com.example.demo.repos;

import com.example.demo.model.Task;

import java.util.Collection;
import java.util.List;

public interface TaskManagerRepo {
    Collection<Task> showAllTasks();
    Task showTask(Long id);
    boolean addTask(Task task);
    boolean deleteTask(Task task);
    boolean updateTask(Long id, Task task);
}
