package com.example.demo.service;

import com.example.demo.model.Task;
import com.example.demo.repos.TaskManagerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class TaskService {
    private TaskManagerRepo taskManagerRepo;

    @Autowired
    public TaskService(TaskManagerRepo taskManagerRepo) {
        this.taskManagerRepo = taskManagerRepo;
    }

    public void addTask(Task task){
        taskManagerRepo.addTask(task);
    }

    public List<Task> showTasks(){
        return taskManagerRepo.showTasks();
    }

    public void deleteTask(Task task){
        taskManagerRepo.deleteTask(task);
    }

    public void setTaskId(Task task){
        task.setId((long) showTasks().indexOf(task));
    }

    public Task findTaskById(Long id){
        return showTasks().get(Math.toIntExact(id));
    }

}
