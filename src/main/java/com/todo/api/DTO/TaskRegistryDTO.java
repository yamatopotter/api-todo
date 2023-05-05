package com.todo.api.DTO;

public record TaskRegistryDTO (
        Long id_user,
        Long id_alert,
        String simple_description,
        String long_description
) {
}
