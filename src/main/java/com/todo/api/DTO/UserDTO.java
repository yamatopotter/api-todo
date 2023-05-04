package com.todo.api.DTO;

import com.todo.api.entity.UserEntity;

public record UserDTO(
        Long id,
        String name,
        String email
) {
}
