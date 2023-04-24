package com.todo.api.repository;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name="user")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserRepository {

    @Id
    private Long id;
    @Column (length=40)
    private String name;
    @Column (length = 150)
    private String email;
    @Column (length = 20)
    private String provider;
}
