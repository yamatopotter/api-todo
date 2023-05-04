package com.todo.api.DTO;

public record TaskDTO(
    Long id,
    AlertDTO alert,
    String simple_description,
    String long_description,
    Integer task_order,
    Boolean is_done,
    Boolean is_deleted
) {
}
