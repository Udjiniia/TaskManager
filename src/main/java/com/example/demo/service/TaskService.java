package com.example.demo.service;

import com.example.demo.model.Task;
import com.example.demo.model.TaskPriority;
import com.example.demo.repos.TaskManagerRepoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TaskService {
    private TaskManagerRepoImpl taskManagerRepoImpl;

    @Autowired
    public TaskService(TaskManagerRepoImpl taskManagerRepoImpl) {
        this.taskManagerRepoImpl = taskManagerRepoImpl;
    }

    public boolean addTask(Task task){
        return taskManagerRepoImpl.addTask(task);
    }

    public List<Task> showAllTasks(){
        return taskManagerRepoImpl.showAllTasks();
    }

    public Task showTask(Long id){
        return taskManagerRepoImpl.showTask(id);
    }

    public boolean deleteTask(Task task){
        return taskManagerRepoImpl.deleteTask(task);
    }

    public void setTaskId(Task task){
        task.setId();
    }

    public Task findTaskById(Long id){
        return taskManagerRepoImpl.showTask(id);
    }

    public boolean updateTask(Long id, Task task){
        return taskManagerRepoImpl.updateTask(id, task);
    }

    public List<Task> filterByPriority(int priority){
        List<Task> tasks = new ArrayList<>();
        for (Task task: showAllTasks()){
            if (task.getTaskPriority() == priority){
                tasks.add(task);
            }
        }
        return tasks;
    }

    public List<Task> filterByName(String name){
        List<Task> tasks = new ArrayList<>();
        for (Task task: showAllTasks()){
            if (task.getTaskName().equals(name)){
                tasks.add(task);
            }
        }
        return tasks;
    }

    public List<Task> filterByStatus(boolean isDone){
        List<Task> tasks = new ArrayList<>();
        for (Task task: showAllTasks()){
            if (task.getTaskStatus() == isDone){
                tasks.add(task);
            }
        }
        return tasks;
    }

    public List<Task> showAllTasksPaginated(int size, int page){
        ArrayList<Task> tasks = new ArrayList<>(showAllTasks());
        int start = size*(page-1);
        int end = size*page;
        if (page*size <= tasks.size() && tasks.size() <= size) return tasks;
        if (page*size > tasks.size()){
            end = tasks.size();
        }
        return tasks.subList(start, end);
    }
}
