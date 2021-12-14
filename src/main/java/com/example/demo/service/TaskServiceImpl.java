package com.example.demo.service;

import com.example.demo.model.Task;
import com.example.demo.model.TaskPriority;
import com.example.demo.repos.TaskManagerRepo;
import com.example.demo.repos.TaskManagerRepoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TaskServiceImpl implements TaskService {

    @Autowired
    private TaskManagerRepo taskManagerRepo;

    @Override
    public int createTask(Task task) {
        return taskManagerRepo.createTask(task);
    }

    @Override
    public Collection<Task> getAllTasks() {
        return taskManagerRepo.getAllTasks();
    }

    @Override
    public void deleteById(int id) {
        taskManagerRepo.deleteById(id);
    }

    @Override
    public void update(Task task, int id) {
        Task oldTask = taskManagerRepo.getByID(id);

        if (oldTask.getTaskPriority() != task.getTaskPriority()) {
            System.out.println(oldTask.getTaskPriority());
            System.out.println(task.getTaskPriority());

            Task taskWithSamePriority = getByPriority(task.getTaskPriority());
            int idOfTaskWithSamePriority = taskWithSamePriority.getId();

            taskWithSamePriority.setTaskPriority(oldTask.getTaskPriority());

            taskManagerRepo.update(taskWithSamePriority, idOfTaskWithSamePriority);
        }

        taskManagerRepo.update(task, id);
    }

    @Override
    public Task getByPriority(int priority) {
        return taskManagerRepo.getByPriority(priority);
    }

    @Override
    public Collection<Task> getByName(String name) {
        return taskManagerRepo.getByName(name);
    }

    @Override
    public Task getById(int id) {
        return taskManagerRepo.getByID(id);
    }
}
