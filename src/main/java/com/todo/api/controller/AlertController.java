package com.todo.api.controller;

import com.todo.api.entity.AlertEntity;
import com.todo.api.entity.TaskEntity;
import com.todo.api.service.AlertService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/alert")
public class AlertController {

    @Autowired
    AlertService alertService;

    @PostMapping
    public ResponseEntity addAlert(@RequestBody AlertEntity alert){
        if(alert != null){
            return alertService.addAlert(alert);
        }
        return ResponseEntity.badRequest().build();
    }

    @GetMapping
    public ResponseEntity listAlerts(){
        return alertService.listAlerts();
    }

    @GetMapping("/{id}")
    public ResponseEntity getAlert(@PathVariable Long id){
        return alertService.getAlert(id);
    }

    @PutMapping
    public ResponseEntity updateAlert(@RequestBody AlertEntity alert){
        if(alert != null){
            return alertService.updateUser(alert);
        }

        return ResponseEntity.badRequest().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteAlert(@PathVariable Long id){
        return alertService.hardDeleteAlert(id);
    }
}
}
