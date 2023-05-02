package com.todo.api.entity;

import jakarta.persistence.*;
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
    @Column(name="id")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    @OneToOne(mappedBy = "alert")
    private TaskEntity task;
    @Column
    private LocalDateTime start_date;
    @Column
    private LocalDateTime end_date;
    @Column
    private Boolean deleted;
}
