package com.todo.api.service;

import com.todo.api.DTO.AlertDTO;
import com.todo.api.DTO.AlertDTOMapper;
import com.todo.api.entity.AlertEntity;
import com.todo.api.repository.IAlertRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AlertService {
    @Autowired
    private IAlertRepository alertRepository;
    @Autowired
    private AlertDTOMapper alertDTOMapper;

    public Optional<AlertDTO> getAlert(Long id){
        Optional<AlertDTO> alert = Optional.ofNullable(alertDTOMapper.apply(alertRepository.findById(id)));

        if(alert.isPresent()){
            return alert;
        }
        return Optional.empty();
    }

    public Optional<AlertDTO> addAlert(AlertDTO alert){
        if(alert != null){
            return alertDalertRepository.saveAndFlush(alert);
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
