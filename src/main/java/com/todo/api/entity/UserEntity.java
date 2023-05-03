package com.todo.api.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.todo.api.DTO.UserDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
@Entity(name="user")
@Table(name="user")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class UserEntity {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    @Column (length=40)
    private String name;
    @Column (length = 150)
    private String email;
    @Column(length=32)
    private String password;
    @Column (length = 3)
    private String provider;
    @Column
    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime created_at;

    public UserDTO toDto(){
        return new UserDTO(this.id, this.name, this.email);
    }
}
