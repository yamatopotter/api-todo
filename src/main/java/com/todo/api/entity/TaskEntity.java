package com.todo.api.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
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
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class TaskEntity {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_user")
    private UserEntity user;
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_alert")
    private AlertEntity alert;
    @Column
    private String simple_description;
    @Column
    private String long_description;
    @Column
    private Integer task_order;
    @Column
    private Boolean is_done;
    @Column
    private Boolean deleted;
    @Column
    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime created_at;
}
