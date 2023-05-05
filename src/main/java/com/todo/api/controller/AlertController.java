package com.todo.api.controller;

import com.todo.api.DTO.AlertDTO;
import com.todo.api.DTO.AlertRegisterDTO;
import com.todo.api.service.AlertService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/alert")
public class AlertController {

    @Autowired
    AlertService alertService;

    @PostMapping
    public ResponseEntity addAlert(@RequestBody AlertRegisterDTO alert){
        if(alert != null){
            Optional<AlertDTO> newAlert = alertService.addAlert(alert);
            if(newAlert.isPresent()){
                return new ResponseEntity<>(newAlert, HttpStatus.CREATED);
            }
        }
        return ResponseEntity.badRequest().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity getAlert(@PathVariable Long id){
        Optional<AlertDTO> alert = alertService.getAlert(id);
        if(alert.isPresent()){
            return ResponseEntity.ok(alert);
        }

        return ResponseEntity.notFound().build();
    }

    @PutMapping
    public ResponseEntity updateAlert(@RequestBody AlertDTO alert){
        if(alert != null){
            Optional<AlertDTO> updatedAlert = alertService.updateUser(alert);

            if(updatedAlert.isPresent()) {
                return ResponseEntity.ok(updatedAlert);
            }
        }

        return ResponseEntity.badRequest().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteAlert(@PathVariable Long id){
        if(alertService.hardDeleteAlert(id)){
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.badRequest().build();
    }

}