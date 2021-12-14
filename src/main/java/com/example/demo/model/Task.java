package com.example.demo.model;

import lombok.Data;

import java.util.Date;

@Data
public class Task {

    private int id;
    private String taskName;
    private int taskPriority;
    private Date taskDate;
    private boolean taskStatus;


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
