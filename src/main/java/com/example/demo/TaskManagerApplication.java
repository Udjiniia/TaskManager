package com.example.demo;

import com.example.demo.model.Task;
import com.example.demo.model.TaskDate;
import com.example.demo.model.TaskPriority;
import com.example.demo.service.TaskServiceCrud;
import com.example.demo.service.TaskServiceFilterPagination;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.text.ParseException;

@SpringBootApplication
public class TaskManagerApplication {

    private final TaskServiceCrud taskServiceCrud;
    private final TaskServiceFilterPagination taskServiceFilterPagination;

    public TaskManagerApplication(TaskServiceCrud taskServiceCrud, TaskServiceFilterPagination taskServiceFilterPagination) {
        this.taskServiceCrud = taskServiceCrud;
        this.taskServiceFilterPagination = taskServiceFilterPagination;
    }

    public static void main(String[] args) {
        SpringApplication.run(TaskManagerApplication.class, args);

    }

    @Bean
    void addTasks() throws ParseException {
        Task task0 = new Task("Cleaning", new TaskPriority(2),
                new TaskDate("2021-04-14"), false);
        taskServiceCrud.addTask(task0);
        taskServiceCrud.setTaskId(task0);

        Task task1 = new Task("Homework", new TaskPriority(1),
                new TaskDate("2021-10-10"), false);
        taskServiceCrud.addTask(task1);
        taskServiceCrud.setTaskId(task1);

        Task task2 = new Task("Vacuuming", new TaskPriority(1),
                new TaskDate("2021-08-12"), true);
        taskServiceCrud.addTask(task2);
        taskServiceCrud.setTaskId(task2);

        Task task3 = new Task("Gaming", new TaskPriority(4),
                new TaskDate("2021-11-12"), true);
        taskServiceCrud.addTask(task3);
        taskServiceCrud.setTaskId(task3);

        System.out.println(taskServiceFilterPagination.filterByName("Vacuuming"));

    }
}
