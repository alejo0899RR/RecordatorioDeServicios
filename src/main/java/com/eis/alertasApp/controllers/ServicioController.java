package com.eis.alertasApp.controllers;

import com.eis.alertasApp.Exception.ResourceNotFoundException;
import com.eis.alertasApp.models.Servicio;
import com.eis.alertasApp.services.ServicioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class ServicioController {
    @Autowired
    private ServicioService servicioService;

    @GetMapping("/servicios")
    public List<Servicio> getAll()
    {
        return servicioService.getAllServicios();
    }

    @GetMapping("/servicios/{id}")
    public Optional<Servicio> getServicioById(@PathVariable(value="id") Integer id)
    {
        return Optional.ofNullable(servicioService.getServicioById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Servicio no existente en la base de datos con el id " + id)));
    }

    @PostMapping("/servicios")
    public String saveServicio(@RequestBody Servicio servicio)
    {
        servicioService.saveServicio(servicio);
        return "Exito del registro";
    }

    @DeleteMapping("/servicios/{id}")
    public String deleteServicice(@PathVariable(value="id") Integer id) {
        servicioService.deleteServicioById(id);
        return "Registro eliminado correctamente";
    }

    @PutMapping("/servicios/{id}")
    public String updateServicio(@PathVariable Integer id, @RequestBody Servicio updatedServicio) {
        servicioService.updateService(id, updatedServicio);
        return "El registro ha sido actualizado";
    }
}
