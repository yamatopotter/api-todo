package com.todo.api.service;

import com.todo.api.entity.UserEntity;
import com.todo.api.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private IUserRepository userRepository;

    public List<UserEntity> listUsers(){
        return userRepository.findAll();
    }

    public ResponseEntity<Optional<UserEntity>> getUser(Long id){
        Optional<UserEntity> user = userRepository.findById(id);

        if(user.isPresent()){
            return new ResponseEntity<>(user, HttpStatus.OK);
        }
        return ResponseEntity.notFound().build();
    }

    public ResponseEntity<UserEntity> addUser(UserEntity user){
        if(user != null){
            return new ResponseEntity<UserEntity>(userRepository.saveAndFlush(user), HttpStatus.CREATED);
        }
        return ResponseEntity.notFound().build();
    }

    public ResponseEntity<String> hardDeleteUser(Long id){
        if(userRepository.findById(id).isPresent()){
            userRepository.deleteById(id);
            return ResponseEntity.ok().body("Usuário excluído com sucesso.");
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Usuário não encontrado.");
    }

    public ResponseEntity<Optional<UserEntity>> updateUser(UserEntity user){
        if(user != null && userRepository.findById(user.getId()).isPresent()) {
            return ResponseEntity.ok(Optional.of(userRepository.saveAndFlush(user)));
        }
        return ResponseEntity.notFound().build();
    }
}
