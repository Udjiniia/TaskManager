package com.example.demo.repos;

import com.example.demo.model.Task;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
@AllArgsConstructor
public class TaskManagerRepoImpl implements TaskManagerRepo {
    private JdbcTemplate jdbcTemplate;

    @Value("${sql.task.create}")
    private String sqlCreate;
    @Value("${sql.task.getId}")
    private String sqlReturnId;
    @Value("${sql.task.update}")
    private String sqlUpdate;
    @Value("${sql.task.delete")
    private String sqlDelete;
    @Value("${sql.task.findByPriority")
    private String sqlFindByPriority;
    @Value("${sql.task.countByPriority")
    private String sqlCountByPriority;
    @Value("${sql.task.findByName")
    private String sqlFindByName;
    @Value("${sql.task.findAllTasks}")
    private String sqlFindAll;


    @Override
    public Collection<Task> getAllTasks() {
        return jdbcTemplate.query(sqlFindAll, new BeanPropertyRowMapper<>(Task.class));
    }

    @Override
    public int createTask(Task task) {
        jdbcTemplate.update(sqlCreate, task.getTaskName(), task.getTaskPriority(), task.getTaskDate());
        Integer result = jdbcTemplate.queryForObject(sqlReturnId, Integer.class);
        return result == null ? 0 : result;
    }

    @Override
    public void update(Task task) {
        jdbcTemplate.update(sqlUpdate, task.getTaskName(), task.getTaskPriority(), task.getTaskDate(), task.isTaskStatus(), task.getId());
    }

    @Override
    public void deleteById(int id) {
        jdbcTemplate.update(sqlDelete, id);
    }

    @Override
    public Task getByPriority(int priority) {
        return jdbcTemplate.queryForObject(sqlFindByPriority, Task.class, priority);
    }

    @Override
    public int countByPriority(int priority) {
        Integer result = jdbcTemplate.queryForObject(sqlCountByPriority, Integer.class);
        return result == null ? 0 : result;
    }

    @Override
    public Collection<Task> getByName(String name) {
        return jdbcTemplate.query(sqlFindByName, new BeanPropertyRowMapper<>(Task.class), name);
    }
}
