package com.todo.api.controller;

import com.todo.api.entity.UserEntity;
import com.todo.api.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping
    public ResponseEntity addUser(@RequestBody UserEntity user){
        if(user != null){
           return userService.addUser(user);
        }
        return ResponseEntity.badRequest().build();
    }

    @GetMapping
    public ResponseEntity<Optional<List<UserEntity>>> listUsers(){
            return userService.listUsers();
    }

    @PutMapping
    public ResponseEntity<Optional<UserEntity>> updateUser(UserEntity user){
        if(user != null){
            return userService.updateUser(user);
        }

        return ResponseEntity.badRequest().build();
    }
}
