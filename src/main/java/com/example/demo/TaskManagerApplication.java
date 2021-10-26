package com.example.demo;

import com.example.demo.model.Task;
import com.example.demo.model.TaskDate;
import com.example.demo.model.TaskPriority;
import com.example.demo.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;

@SpringBootApplication
public class TaskManagerApplication {

    @Autowired
    private TaskService taskService;
    public static void main(String[] args) {
        SpringApplication.run(TaskManagerApplication.class, args);
//        ApplicationContext context = SpringApplication.run(TaskManagerApplication.class);
        TaskManagerApplication taskManagerApplication = new TaskManagerApplication();
//        taskManagerApplication.addTasks();
    }

    @Bean
    void addTasks() throws ParseException {
        Task task = new Task("Denis", new TaskPriority(1),
                new TaskDate("2021-04-14"), false);
        taskService.addTask(task);
        taskService.setTaskId(task);
    }
}
