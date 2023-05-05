package com.todo.api.DTO;

import java.time.LocalDateTime;

public record AlertRegisterDTO(
        LocalDateTime start_date,
        LocalDateTime end_date
) {
}
