package com.todo.api.DTO;

public record UserRegisterDTO (
        String name,
        String email,
        String password,
        String provider
){
}
