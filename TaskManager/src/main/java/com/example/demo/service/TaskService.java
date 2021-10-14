package com.example.demo.service;

import com.example.demo.model.Task;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TaskService {

    @Bean
    @Scope("prototype")
    public Task newTask() {
        return new Task();
    }

    private List<Task> listOfTasks = new ArrayList<>();

    {
        Task task1 = newTask();
        task1.setTask("Погулять с Сэмом");
        task1.setPriority(1);
        task1.setDone(false);
        listOfTasks.add(task1);

        Task task2 = newTask();
        task2.setTask("Покормить Сэма");
        task2.setPriority(2);
        task2.setDone(false);
        listOfTasks.add(task2);
    }

    public void addTask(Task task) {
        listOfTasks.add(task);
    }

    public void removeTask(String taskDescription) {
        listOfTasks.removeIf(task -> task.getTask().equals(taskDescription));
    }


    public void removeTask(int priority) {
        listOfTasks.removeIf(task -> task.getPriority() == priority);
    }

    public void removeTask(boolean isTaskDone) {
        listOfTasks.removeIf(task -> !task.isDone());
    }

    public void updateTask(String oldTask, String newTask) {
        for (Task task : listOfTasks) {
            if (task.getTask().equals(oldTask)) {
                task.setTask(newTask);
            }
        }
    }

    public void updateTask(int oldPriority, int newPriority) {
        for (Task task : listOfTasks) {
            if (task.getPriority() == oldPriority) {
                task.setPriority(newPriority);
            }
        }
    }

    public void updateTask(String oldTask, String newTask, int oldPriority, int newPriority) {
        for (Task task : listOfTasks) {
            if (task.getTask().equals(oldTask) && task.getPriority() == oldPriority) {
                task.setTask(newTask);
                task.setPriority(newPriority);
            }
        }
    }


    public void setTaskDone(String taskDescription) {
        for (Task task : listOfTasks) {
            if (task.getTask().equals(taskDescription)) {
                task.setDone(true);
            }
        }
    }

    public ArrayList<Task> getTasks() {
        return (ArrayList<Task>) listOfTasks;
    }

}
