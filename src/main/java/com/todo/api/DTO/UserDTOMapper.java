package com.todo.api.DTO;

import com.todo.api.entity.UserEntity;
import java.util.function.Function;
import org.springframework.stereotype.Service;

@Service
public class UserDTOMapper implements Function<UserEntity, UserDTO> {
    @Override
    public UserDTO apply(UserEntity user){
        return new UserDTO(
                user.getId(),
                user.getName(),
                user.getEmail()
        );
    }
}
