package com.todo.api.repository;

import com.todo.api.entity.TaskEntitiy;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ITaskRepository extends JpaRepository<TaskEntitiy, Long> {
}
