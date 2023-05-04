package com.todo.api.DTO;

import com.todo.api.entity.AlertEntity;
import com.todo.api.entity.UserEntity;
import org.springframework.stereotype.Service;

import java.util.function.Function;

@Service
public class AlertDTOMapper implements Function<AlertEntity, AlertDTO> {
    @Override
    public AlertDTO apply(AlertEntity alert){
        return new AlertDTO(
                alert.getId(),
                alert.getStart_date(),
                alert.getEnd_date()
        );
    }
}
