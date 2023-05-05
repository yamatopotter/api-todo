package com.todo.api.service;

import com.todo.api.DTO.AlertDTO;
import com.todo.api.DTO.AlertDTOMapper;
import com.todo.api.DTO.AlertRegisterDTO;
import com.todo.api.entity.AlertEntity;
import com.todo.api.repository.IAlertRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.Optional;

@Service
public class AlertService {
    @Autowired
    private IAlertRepository alertRepository;
    @Autowired
    private AlertDTOMapper alertDTOMapper;

    public Optional<AlertDTO> getAlert(Long id){
        Optional<AlertDTO> alert;
        alert = alertRepository.findById(id).map(alertDTOMapper);

        if(alert.isPresent()){
            return alert;
        }
        return Optional.empty();
    }

    public Optional<AlertDTO> addAlert(AlertRegisterDTO alert){
        if(alert != null){
            AlertEntity newAlert = alertRepository.saveAndFlush(
                    new AlertEntity(
                            null,
                            alert.start_date(),
                            alert.end_date(),
                            false
                    )
            );
            return Optional.of(alertDTOMapper.apply(newAlert));
        }
        return Optional.empty();
    }

    public Boolean hardDeleteAlert(Long id){
        if(alertRepository.findById(id).isPresent()){
            alertRepository.deleteById(id);
            return true;
        }
        return false;
    }

    public Optional<AlertDTO> updateUser(AlertDTO alert){
        if(alert != null && alertRepository.findById(alert.id()).isPresent()) {
            AlertEntity updatedAlertEntity = alertRepository.saveAndFlush( new AlertEntity(
                    alert.id(),
                    alert.start_date(),
                    alert.end_date(),
                    false
            ));

            return Optional.of(alertDTOMapper.apply(updatedAlertEntity));
        }
        return Optional.empty();
    }
}
