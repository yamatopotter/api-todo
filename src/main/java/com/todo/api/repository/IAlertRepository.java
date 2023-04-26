package com.todo.api.repository;

import com.todo.api.entity.AlertEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IAlertRepository extends JpaRepository<AlertEntity, Long> {
}
