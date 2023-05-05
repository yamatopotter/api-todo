package com.todo.api.DTO;

public record TaskUpdateDTO(
        Long id,
        Long id_user,
        Long id_alert,
        String simple_description,
        String long_description,
        Integer task_order,
        Boolean is_done,
        Boolean is_deleted
) {
}
