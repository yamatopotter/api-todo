package com.todo.api.controller;

import com.todo.api.entity.TaskEntitiy;
import com.todo.api.repository.ITaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.time.LocalDateTime;

@Controller
@RequestMapping("/task")
public class TaskController {

    @Autowired
    private ITaskRepository taskRepository;

    @PostMapping
    public @ResponseBody TaskEntitiy addNewTask(@RequestParam Long id_user, @RequestParam String simple_description, @RequestParam String long_description, @RequestParam Integer task_order){
        TaskEntitiy t = new TaskEntitiy();
        t.setId_user(id_user);
        t.setSimple_description(simple_description);
        t.setLong_description(long_description);
        t.setTask_order(task_order);
        t.setIs_done(false);
        t.setDeleted(false);
        t.setCreated_at(LocalDateTime.now());

        taskRepository.save(t);

        return t;
    }
}
