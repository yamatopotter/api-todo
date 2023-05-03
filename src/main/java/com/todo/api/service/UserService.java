package com.todo.api.service;

import com.todo.api.DTO.UserDTO;
import com.todo.api.entity.UserEntity;
import com.todo.api.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private IUserRepository userRepository;
    public Optional<UserDTO> getUser(Long id){
        Optional<UserEntity> user = userRepository.findById(id);

        if(user.isPresent()){
            return Optional.of(new UserDTO(user.get().getId(), user.get().getName(), user.get().getEmail()));
        }
        return Optional.of(new UserDTO());
    }

    public Optional<UserDTO> addUser(UserDTO user){
        if(user != null){
            return Optional.ofNullable(userRepository.saveAndFlush(user.toEntity()).toDto());
        }
        return Optional.of(new UserDTO())
    }

    public ResponseEntity<String> hardDeleteUser(Long id){
        if(userRepository.findById(id).isPresent()){
            userRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }

    public ResponseEntity<Optional<UserEntity>> updateUser(UserEntity user){
        if(user != null && userRepository.findById(user.getId()).isPresent()) {
            return ResponseEntity.ok(Optional.of(userRepository.saveAndFlush(user)));
        }
        return ResponseEntity.notFound().build();
    }
}
