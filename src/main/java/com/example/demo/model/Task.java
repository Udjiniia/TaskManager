package com.example.demo.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Data
@Entity
@Table(name = "task")
public class Task {

    @Id
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
