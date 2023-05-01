package com.todo.api.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
@Entity
@Table(name="user")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserEntity {
    @Id
    @GeneratedValue
    private Long id;
    @Column (length=40)
    private String name;
    @Column (length = 150)
    private String email;
    @Column (length = 20)
    private String provider;
    @Column
    private LocalDateTime created_at;
}
