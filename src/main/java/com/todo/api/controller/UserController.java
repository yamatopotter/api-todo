package com.todo.api.controller;

import com.electronwill.nightconfig.core.conversion.Path;
import com.todo.api.DTO.UserDTO;
import com.todo.api.entity.UserEntity;
import com.todo.api.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
    public ResponseEntity addUser(@RequestBody UserDTO user){
        if(user != null){
           return new ResponseEntity<>(userService.addUser(user), HttpStatus.CREATED);
        }
        return ResponseEntity.badRequest().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity getUser(@PathVariable Long id){
        Optional<UserDTO> user = userService.getUser(id);

        if(user.isPresent()){
            return ResponseEntity.ok(user);
        }

        return ResponseEntity.notFound().build();
    }

    @PutMapping
    public ResponseEntity<Optional<UserEntity>> updateUser(@RequestBody UserEntity user){
        if(user != null){
            return userService.updateUser(user);
        }

        return ResponseEntity.badRequest().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> hardDeleteUser(@PathVariable Long id){
        return userService.hardDeleteUser(id);
    }
}
