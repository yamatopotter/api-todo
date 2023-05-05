package com.todo.api.controller;

import com.todo.api.DTO.TaskDTO;
import com.todo.api.DTO.TaskRegistryDTO;
import com.todo.api.DTO.TaskUpdateDTO;
import com.todo.api.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Optional;

@RestController
@RequestMapping("/task")
public class TaskController {
    @Autowired
    private TaskService taskService;

    @PostMapping
    public ResponseEntity addTask(@RequestBody TaskRegistryDTO task){
        if(task != null){
            Optional<TaskDTO> newTask = taskService.addTask(task);
            if(newTask.isPresent()){
                return  new ResponseEntity<>(newTask, HttpStatus.CREATED);
            }

        }
        return ResponseEntity.badRequest().build();
    }

    @GetMapping
    public ResponseEntity listTasks(){
        return taskService.listTasks();
    }

    @GetMapping("/{id}")
    public ResponseEntity getTask(@PathVariable Long id){
        Optional<TaskDTO> task = taskService.getTask(id);

        if(task.isPresent()){
            return ResponseEntity.ok(task);
        }

        return ResponseEntity.notFound().build();
    }

    @PutMapping
    public ResponseEntity updateTask(@RequestBody TaskUpdateDTO task){
        if(task != null){
            Optional<TaskDTO> updatedTask =  taskService.updateTask(task);

            if(updatedTask.isPresent()){
                return ResponseEntity.ok(updatedTask);
            }
        }

        return ResponseEntity.badRequest().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteTask(@PathVariable Long id){
        if(taskService.hardDeleteTask(id)){
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.badRequest().build();
    }
}
