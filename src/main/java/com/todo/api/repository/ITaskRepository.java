package com.todo.api.repository;

import com.todo.api.entity.TaskEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ITaskRepository extends JpaRepository<TaskEntity, Long> {
}
