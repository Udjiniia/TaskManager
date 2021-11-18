package com.example.demo.model;


import java.text.*;
import java.util.Date;

public class TaskDate {
    private Date taskDate;
    private DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

    public TaskDate(String date) throws ParseException {
        this.taskDate = dateFormat.parse(date);
    }

    public Date getTaskDate() {
        return taskDate;
    }

    @Override
    public String toString() {
        return dateFormat.format(taskDate);
    }
}
