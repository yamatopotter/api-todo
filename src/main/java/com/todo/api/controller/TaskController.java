package com.todo.api.controller;

import com.todo.api.entity.TaskEntity;
import com.todo.api.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.Optional;

@Controller
@RequestMapping("/task")
public class TaskController {
    @Autowired
    private TaskService taskService;

    @PostMapping
    public ResponseEntity<Optional<TaskEntity>> addTask(){
        return ResponseEntity.badRequest().build();
    }
}
