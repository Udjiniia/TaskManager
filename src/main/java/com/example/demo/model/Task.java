package com.example.demo.model;

public class Task {
    private static Long counter = 0L;
    private Long id;
    private String taskName;
    private TaskPriority taskPriority;
    private TaskDate taskDate;
    private boolean taskStatus;


    public Task(String taskName, TaskPriority taskPriority, TaskDate taskDate, boolean taskStatus) {
        this.id = counter++;
        this.taskName = taskName;
        this.taskPriority = taskPriority;
        this.taskDate = taskDate;
        this.taskStatus = taskStatus;
    }

    public Long getId() {
        return id;
    }

    public void setId() {
        this.id = getCounter();
    }

    public void setId(Long id) {
        this.id = id;
    }

    public static Long getCounter() {
        return counter;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public int getTaskPriority() {
        return taskPriority.getPriorityNumber();
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

    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                ", taskName='" + taskName + '\'' +
                ", taskPriority=" + taskPriority +
                ", taskDate=" + taskDate +
                ", taskStatus=" + taskStatus +
                '}';
    }
}
