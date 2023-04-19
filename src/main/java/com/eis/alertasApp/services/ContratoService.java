package com.eis.alertasApp.services;

import com.eis.alertasApp.Exception.ResourceNotFoundException;
import com.eis.alertasApp.models.Contrato;
import com.eis.alertasApp.models.Servicio;
import com.eis.alertasApp.repositories.ContratoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ContratoService {
    @Autowired
    private ContratoRepository contratoRepository;
    public List<Contrato> getAllContratos() {

        return (List<Contrato>) contratoRepository.findAll();
    }
    public Optional<Contrato> getContratoById(Integer id_contrato) {
        return contratoRepository.findById(id_contrato);
    }
    public Contrato saveContrato(Contrato contrato){
        Contrato saveContrato = contratoRepository.save(contrato);
        return saveContrato;
    }
    public void deleteContratoById(Integer id) {
        contratoRepository.deleteById(id);
    }
    public Contrato updateContrato(Integer id_contrato, Contrato updatedContrato) {
        Contrato existingContrato = contratoRepository.findById(id_contrato).orElseThrow(() -> new ResourceNotFoundException("contrato not found with id " + id_contrato));
        existingContrato.setId_contrato(id_contrato);
        existingContrato.setDescripcion(updatedContrato.getDescripcion());
        existingContrato.setServicio(updatedContrato.getServicio());
        existingContrato.setValor(updatedContrato.getValor());
        existingContrato.setFecha(updatedContrato.getFecha());
        return contratoRepository.save(existingContrato);
    }

}
