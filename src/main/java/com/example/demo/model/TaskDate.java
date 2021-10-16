package com.example.demo.model;

import org.springframework.format.annotation.DateTimeFormat;

import java.text.*;
import java.util.Date;

public class TaskDate {
//    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date taskDate;
    private DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

    public TaskDate(String date) throws ParseException {
        this.taskDate = dateFormat.parse(date);
    }

    @Override
    public String toString() {
        return dateFormat.format(taskDate);
    }
}
