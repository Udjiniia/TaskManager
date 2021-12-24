package com.example.demo.repos;

import com.example.demo.model.Task;
import org.springframework.data.repository.CrudRepository;

import java.util.Collection;

public interface TaskManagerRepository extends CrudRepository<Task, Integer> {
    Task findById(int Id);
    Task findByTaskPriority(int priority);
    Collection<Task> findByTaskName(String name);
}
