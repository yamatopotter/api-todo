package com.todo.api.DTO;

import com.todo.api.entity.Role;

public record UserRegisterDTO (
        String name,
        String email,
        String password,
        Role role
){
}
