package com.todo.api.service;

import com.todo.api.entity.TaskEntity;
import com.todo.api.repository.ITaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskService{

    @Autowired
    private ITaskRepository taskRepository;

    public ResponseEntity<List<TaskEntity>> listTasks(){
        return new ResponseEntity(taskRepository.findAll(), HttpStatus.OK);
    }

    public ResponseEntity<Optional<TaskEntity>> getTask(Long id){
        Optional<TaskEntity> task = taskRepository.findById(id);

        if(task.isPresent()){
            return new ResponseEntity<>(task, HttpStatus.OK);
        }
        return new ResponseEntity<>(task, HttpStatus.NOT_FOUND);
    }

    public ResponseEntity<TaskEntity> addTask(TaskEntity task){
        if(task != null){
            return new ResponseEntity<>(taskRepository.saveAndFlush(task), HttpStatus.CREATED);
        }
        return ResponseEntity.notFound().build();
    }

    public ResponseEntity<String> hardDeleteTask(Long id){
        if(taskRepository.findById(id).isPresent()){
            taskRepository.deleteById(id);
            return ResponseEntity.ok().body("Tarefa excluída com sucesso.");
        }
        return ResponseEntity.notFound().build();
    }

    public ResponseEntity<Optional<TaskEntity>> updateTask(TaskEntity task){
        if(task != null && taskRepository.findById(task.getId()).isPresent()) {
            return new ResponseEntity<>(Optional.of(taskRepository.saveAndFlush(task)), HttpStatus.OK);
        }
        return ResponseEntity.badRequest().build();
    }
}
