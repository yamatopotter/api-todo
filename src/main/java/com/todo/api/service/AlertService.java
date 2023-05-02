package com.todo.api.service;

import com.todo.api.entity.AlertEntity;
import com.todo.api.repository.IAlertRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public class AlertService {
    @Autowired
    private IAlertRepository alertRepository;

    public ResponseEntity listAlerts(){
        return new ResponseEntity<>(alertRepository.findAll(), HttpStatus.OK);
    }

    public ResponseEntity<Optional<AlertEntity>> getAlert(Long id){
        Optional<AlertEntity> alert = alertRepository.findById(id);

        if(alert.isPresent()){
            return new ResponseEntity<>(alert, HttpStatus.OK);
        }
        return ResponseEntity.notFound().build();
    }

    public ResponseEntity<AlertEntity> addAlert(AlertEntity alert){
        if(alert != null){
            return new ResponseEntity<>(alertRepository.saveAndFlush(alert), HttpStatus.CREATED);
        }
        return ResponseEntity.notFound().build();
    }

    public ResponseEntity<String> hardDeleteAlert(Long id){
        if(alertRepository.findById(id).isPresent()){
            alertRepository.deleteById(id);
            return ResponseEntity.ok().body("Alerta excluído com sucesso.");
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Alerta não encontrado.");
    }

    public ResponseEntity<Optional<AlertEntity>> updateUser(AlertEntity alert){
        if(alert != null && alertRepository.findById(alert.getId()).isPresent()) {
            return ResponseEntity.ok(Optional.of(alertRepository.saveAndFlush(alert)));
        }
        return ResponseEntity.notFound().build();
    }
}
