package com.todo.api.service;

import com.todo.api.DTO.UserDTO;
import com.todo.api.DTO.UserDTOMapper;
import com.todo.api.DTO.UserRegisterDTO;
import com.todo.api.DTO.UserUpdateDTO;
import com.todo.api.entity.UserEntity;
import com.todo.api.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserDTOMapper userDTOMapper;
    @Autowired
    private IUserRepository userRepository;

    public Optional<UserDTO> getUser(Long id){
      Optional<UserDTO> user;
        user = userRepository.findById(id).map(userDTOMapper);

        if(user.isPresent()){
            return user;
        }
        return Optional.of(null);
    }

    public Optional<UserDTO> addUser(UserRegisterDTO user){
        if(user != null){
            UserEntity newUser = userRepository.saveAndFlush(
                    new UserEntity(
                        null,
                        user.name(),
                        user.email(),
                        user.password(),
                        user.provider(),
                        null
                )
            );

            return Optional.of(userDTOMapper.apply(newUser));
        }
        return Optional.of(null);
    }

    public Boolean hardDeleteUser(Long id){
        if(userRepository.findById(id).isPresent()){
            userRepository.deleteById(id);
            return true;
        }
        return false;
    }

    public Optional<UserDTO>updateUser(UserUpdateDTO user){
        if(user != null) {
           UserEntity userToUpdate =  new UserEntity(
                    user.id(),
                    user.name(),
                    user.email(),
                    user.password(),
                    user.provider(),
                    null
            );

           return Optional.of(userDTOMapper.apply(userRepository.saveAndFlush(userToUpdate)));
        }
        return Optional.of(null);
    }
}
