package com.todo.api.DTO;

import java.time.LocalDateTime;

public record AlertDTO(
        Long id,
        LocalDateTime start_date,
        LocalDateTime end_date
) {
}
