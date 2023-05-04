package com.todo.api.controller;

import com.todo.api.DTO.AlertDTO;
import com.todo.api.DTO.AlertDTOMapper;
import com.todo.api.entity.AlertEntity;
import com.todo.api.entity.TaskEntity;
import com.todo.api.service.AlertService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/alert")
public class AlertController {

    @Autowired
    AlertService alertService;
    @Autowired
    AlertDTOMapper alertDTOMapper;

    @PostMapping
    public ResponseEntity addAlert(@RequestBody AlertDTO alert){
        if(alert != null){
            return new ResponseEntity<>(alertService.addAlert(alert), HttpStatus.CREATED);
        }
        return ResponseEntity.badRequest().build();
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
