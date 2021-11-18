package com.example.demo.model;


public class TaskPriority {
    private int priorityNumber;

    public TaskPriority(int priorityNumber) {
        this.priorityNumber = priorityNumber;
    }

    public int getPriorityNumber() {
        return priorityNumber;
    }

    @Override
    public String toString() {
        return String.valueOf(priorityNumber);
    }
}
