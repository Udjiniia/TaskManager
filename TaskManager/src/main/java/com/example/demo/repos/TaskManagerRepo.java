package com.example.demo.repos;

import com.example.demo.model.Task;
import org.springframework.stereotype.Repository;
import org.springframework.data.repository.CrudRepository;

@Repository
public interface TaskManagerRepo extends CrudRepository<Task, Long>{
}
