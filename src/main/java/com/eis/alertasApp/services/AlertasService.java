package com.eis.alertasApp.services;


import com.eis.alertasApp.Exception.ResourceNotFoundException;
import com.eis.alertasApp.models.Alerta;
import com.eis.alertasApp.repositories.AlertasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AlertasService {

    @Autowired
    private AlertasRepository alertasRepository;

    public List<Alerta> getAllAlertas() {
        return alertasRepository.findAll();
    }
    public Optional<Alerta> getAlertaById(Integer id_alerta) {
        return alertasRepository.findById(id_alerta);
    }
    public Alerta saveAlerta(Alerta alerta){
        return alertasRepository.save(alerta);
    }

    public void deleteAlertaById(Integer id) {
        alertasRepository.deleteById(id);
    }

    public Alerta updateAlerta(Integer id_alerta, Alerta updatedAlerta) {
        Alerta existingAlerta = alertasRepository.findById(id_alerta).orElseThrow(() -> new ResourceNotFoundException("alert not found with id " + id_alerta));
        existingAlerta.setId_alerta(id_alerta);
        existingAlerta.setFecha(updatedAlerta.getFecha());
        existingAlerta.setContrato(updatedAlerta.getContrato());
        existingAlerta.setFecha_pago(updatedAlerta.getFecha_pago());
        return alertasRepository.save(existingAlerta);
    }
}
