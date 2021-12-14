package com.example.demo.service;
import com.example.demo.model.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TaskServiceFilterPagination {

    private TaskServiceImpl taskServiceImpl;

    @Autowired
    public TaskServiceFilterPagination(TaskServiceImpl taskServiceImpl) {
        this.taskServiceImpl = taskServiceImpl;
    }


    public List<Task> filterByPriority(int priority){
        List<Task> tasks = new ArrayList<>();
        for (Task task: taskServiceImpl.getAllTasks()){
            if (task.getTaskPriority() == priority){
                tasks.add(task);
            }
        }
        return tasks;
    }

    public List<Task> filterByName(String name){
        List<Task> tasks = new ArrayList<>();
        for (Task task: taskServiceImpl.getAllTasks()){
            if (task.getTaskName().toLowerCase().equals(name.toLowerCase())){
                tasks.add(task);
            }
        }
        return tasks;
    }

    public List<Task> filterByStatus(boolean isDone){
        throw  new UnsupportedOperationException();
        /*List<Task> tasks = new ArrayList<>();
        for (Task task: taskServiceCrud.showAllTasks()){
            if (task.getTaskStatus() == isDone){
                tasks.add(task);
            }
        }
        return tasks;

         */
    }

    public List<Task> showAllTasksPaginated(int size, int page){
        ArrayList<Task> tasks = new ArrayList<>(taskServiceImpl.getAllTasks());
        int start = size*(page-1);
        int end = size*page;
        if (page*size <= tasks.size() && tasks.size() <= size) return tasks;
        if (page*size > tasks.size()){
            end = tasks.size();
        }
        return tasks.subList(start, end);
    }
}
