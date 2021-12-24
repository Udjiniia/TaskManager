package com.example.demo.service;

import com.example.demo.model.Task;
import com.example.demo.repos.TaskManagerRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Collection;

@Service
@AllArgsConstructor
public class TaskServiceImpl implements TaskService {

    private TaskManagerRepository taskManagerRepository;

    @Override
    public Task createTask(Task task) {
        return taskManagerRepository.save(task);
    }

    @Override
    public Collection<Task> getAllTasks() {
        return (Collection<Task>) taskManagerRepository.findAll();
    }

    @Override
    public void deleteById(int id) {
        taskManagerRepository.deleteById(id);
    }

    @Override
    @Transactional
    public void update(Task task, int id) {
        Task oldTask = taskManagerRepository.findById(id);

        if (oldTask.getTaskPriority() != task.getTaskPriority()) {
            System.out.println(oldTask.getTaskPriority());
            System.out.println(task.getTaskPriority());

            Task taskWithSamePriority = getByPriority(task.getTaskPriority());
            //int idOfTaskWithSamePriority = taskWithSamePriority.getId();

            taskWithSamePriority.setTaskPriority(oldTask.getTaskPriority());

            taskManagerRepository.save(taskWithSamePriority);
        }

        taskManagerRepository.save(task);
    }

    @Override
    public Task getByPriority(int priority) {
        return taskManagerRepository.findByTaskPriority(priority);
    }

    @Override
    public Collection<Task> getByName(String name) {
        return taskManagerRepository.findByTaskName(name);
    }

    @Override
    public Task getById(int id) {
        return taskManagerRepository.findById(id);
    }
}
