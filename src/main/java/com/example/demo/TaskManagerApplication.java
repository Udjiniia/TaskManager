package com.example.demo;

import com.example.demo.service.TaskServiceImpl;
import com.example.demo.service.TaskServiceFilterPagination;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TaskManagerApplication {

    public static void main(String[] args) {
        SpringApplication.run(TaskManagerApplication.class, args);

    }
}
