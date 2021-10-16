package com.example.demo.model;
import java.util.Date;

public class Task {
    private Long id;
    private String taskName;
    private TaskPriority taskPriority;
    private TaskDate taskDate;
    private boolean taskStatus;

    public Task(String taskName, TaskPriority taskPriority, TaskDate taskDate, boolean taskStatus) {
        this.id = id;
        this.taskName = taskName;
        this.taskPriority = taskPriority;
        this.taskDate = taskDate;
        this.taskStatus = taskStatus;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public TaskPriority getTaskPriority() {
        return taskPriority;
    }

    public void setTaskPriority(TaskPriority taskPriority) {
        this.taskPriority = taskPriority;
    }

    public TaskDate getTaskDate() {
        return taskDate;
    }

    public void setTaskDate(TaskDate taskDate) {
        this.taskDate = taskDate;
    }

    public boolean getTaskStatus() {
        return taskStatus;
    }

    public void setTaskStatus(boolean taskStatus) {
        this.taskStatus = taskStatus;
    }


}
