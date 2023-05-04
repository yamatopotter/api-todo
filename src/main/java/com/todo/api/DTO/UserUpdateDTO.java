package com.todo.api.DTO;

public record UserUpdateDTO(
        Long id,
        String name,
        String email,
        String password,
        String provider
) {
}
