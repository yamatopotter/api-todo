package com.todo.api.service;

import com.todo.api.DTO.TaskDTO;
import com.todo.api.DTO.TaskDTOMapper;
import com.todo.api.DTO.TaskRegistryDTO;
import com.todo.api.DTO.TaskUpdateDTO;
import com.todo.api.entity.AlertEntity;
import com.todo.api.entity.TaskEntity;
import com.todo.api.entity.UserEntity;
import com.todo.api.repository.IAlertRepository;
import com.todo.api.repository.ITaskRepository;
import com.todo.api.repository.IUserRepository;
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
    @Autowired
    private IUserRepository userRepository;
    @Autowired
    private IAlertRepository alertRepository;
    @Autowired
    private TaskDTOMapper taskDTOMapper;

    public ResponseEntity<List<TaskEntity>> listTasks(){
        return new ResponseEntity(taskRepository.findAll(), HttpStatus.OK);
    }

    public Optional<TaskDTO> getTask(Long id){
        Optional<TaskDTO> task;
        task = taskRepository.findById(id).map(taskDTOMapper);

        if(task.isPresent()){
            return task;
        }
        return Optional.empty();
    }

    public Optional<TaskDTO> addTask(TaskRegistryDTO task){
        if(task != null){
            System.out.println(task);
            Optional<UserEntity> userToTask;
            Optional<AlertEntity> alertToTask;

            userToTask = userRepository.findById(task.id_user());
            alertToTask = alertRepository.findById(task.id_alert());

            TaskEntity newTask = taskRepository.saveAndFlush(
                    new TaskEntity(
                            null,
                            userToTask.get(),
                            (alertToTask.isPresent() ? alertToTask.get() : null),
                            task.simple_description(),
                            task.long_description(),
                            0,
                            false,
                            false,
                            null
                    )
            );
            return  Optional.of(taskDTOMapper.apply(newTask));
        }
        return Optional.empty();
    }

    public Boolean hardDeleteTask(Long id){
        if(taskRepository.findById(id).isPresent()){
            taskRepository.deleteById(id);
            return true;
        }
        return false;
    }

    public Optional<TaskDTO> updateTask(TaskUpdateDTO task){
        if(task != null && taskRepository.findById(task.id()).isPresent()) {
            Optional<UserEntity> userToUpdate = userRepository.findById(task.id_user());
            Optional<AlertEntity> alertToUpdate = null;
            if(task.id_alert() != null){
                alertToUpdate = alertRepository.findById(task.id_alert());
            }

            TaskEntity taskToUpdate = taskRepository.saveAndFlush(
                    new TaskEntity(
                            task.id(),
                            userToUpdate.get(),
                            alertToUpdate.get(),
                            task.simple_description(),
                            task.long_description(),
                            task.task_order(),
                            task.is_done(),
                            task.is_deleted(),
                            null
                    )
            );
            return Optional.of(taskDTOMapper.apply(taskToUpdate));
        }
        return Optional.empty();
    }
}
