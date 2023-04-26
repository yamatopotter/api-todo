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
@Table(name="alert")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AlertEntity {
    @Id
    @GeneratedValue
    private Long id;
    private Long id_task;
    private LocalDateTime start_date;
    private LocalDateTime end_date;
    private Boolean deleted;
}
