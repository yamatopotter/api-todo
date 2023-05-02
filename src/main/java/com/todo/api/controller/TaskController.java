package com.todo.api.controller;

import com.electronwill.nightconfig.core.conversion.Path;
import com.todo.api.entity.TaskEntity;
import com.todo.api.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/task")
public class TaskController {
    @Autowired
    private TaskService taskService;

    @PostMapping
    public ResponseEntity addTask(@RequestBody TaskEntity task){
        if(task != null){
            return taskService.addTask(task);
        }
        return ResponseEntity.badRequest().build();
    }

    @GetMapping
    public ResponseEntity listTasks(){
        return taskService.listTasks();
    }

    @GetMapping("/{id}")
    public ResponseEntity getTask(@PathVariable Long id){
        return taskService.getTask(id);
    }

    @PutMapping
    public ResponseEntity updateTask(@RequestBody TaskEntity task){
        if(task != null){
            return taskService.updateTask(task);
        }

        return ResponseEntity.badRequest().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteTask(@PathVariable Long id){
        return taskService.hardDeleteTask(id);
    }
}
