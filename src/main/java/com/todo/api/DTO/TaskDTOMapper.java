package com.todo.api.DTO;

import com.todo.api.entity.TaskEntity;
import com.todo.api.entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.function.Function;

@Service
public class TaskDTOMapper implements Function<TaskEntity, TaskDTO> {
    @Autowired
    AlertDTOMapper alertDTOMapper;

    @Override
    public TaskDTO apply(TaskEntity task){
        try{
            return new TaskDTO(
                    task.getId(),
                    alertDTOMapper.apply(task.getAlert()),
                    task.getSimple_description(),
                    task.getLong_description(),
                    task.getTask_order(),
                    task.getIs_done(),
                    task.getDeleted()
            );
        }
        catch(Exception e){
            System.out.println("[INFO] create entity without alert");

            return new TaskDTO(
                    task.getId(),
                    null,
                    task.getSimple_description(),
                    task.getLong_description(),
                    task.getTask_order(),
                    task.getIs_done(),
                    task.getDeleted()
            );
        }

    }
}
