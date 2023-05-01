package com.todo.api.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name="task")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class TaskEntity {
    @Id
    @GeneratedValue
    private Long id;
    private Long id_user;
    private String simple_description;
    private String long_description;
    private Integer task_order;
    private Boolean is_done;
    private Boolean deleted;
    private LocalDateTime created_at;
}
