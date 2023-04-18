package com.eis.alertasApp.services;

import com.eis.alertasApp.Exception.ResourceNotFoundException;
import com.eis.alertasApp.models.Servicio;
import com.eis.alertasApp.repositories.ServicioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServicioService {
    @Autowired
    private ServicioRepository servicioRepository;

    public List<Servicio> getAllServicios() {

        return (List<Servicio>) servicioRepository.findAll();
    }

    public Optional<Servicio> getServicioById(Integer id) {
        return servicioRepository.findById(id);
    }

    public Servicio saveServicio(Servicio servicio){
        Servicio saveServicio = servicioRepository.save(servicio);
        return saveServicio;
    }

    public void deleteServicioById(Integer id) {
        servicioRepository.deleteById(id);
    }

    public Servicio updateUser(Integer id, Servicio updatedServicio) {
        Servicio existingServicio = servicioRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("User not found with id " + id));
        existingServicio.setId_servicio(id);
        existingServicio.setNombre(updatedServicio.getNombre());
        existingServicio.setPeriodicidad(updatedServicio.getPeriodicidad());
        return servicioRepository.save(existingServicio);
    }

}
