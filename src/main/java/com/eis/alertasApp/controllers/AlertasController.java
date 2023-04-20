package com.eis.alertasApp.controllers;

import com.eis.alertasApp.models.Alerta;
import com.eis.alertasApp.services.AlertasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class AlertasController {
    @Autowired
    private AlertasService alertasService;

    @GetMapping("/alertas")
    public List<Alerta> getAll()
    {
        List<Alerta> allAlertas = alertasService.getAllAlertas();
        return allAlertas;
    }

    @GetMapping("/alertas/{id}")
    public Optional<Alerta> getAlertasById(@PathVariable(value="id") Integer id_alerta)
    {
        return alertasService.getAlertaById(id_alerta);
    }

    @PostMapping("/alertas")
    public String saveAlerta(@RequestBody Alerta alerta)
    {
        alertasService.saveAlerta(alerta);
        return "Exito del registro";
    }

    @DeleteMapping("/alertas/{id}")
    public String deleteAlerta(@PathVariable(value="id") Integer id_alerta) {
        alertasService.deleteAlertaById(id_alerta);
        return "Registro eliminado correctamente";
    }

    @PutMapping("/alertas/{id}")
    public String updateAlerta(@PathVariable(value="id") Integer id_alerta, @RequestBody Alerta updatedAlerta) {
        alertasService.updateAlerta(id_alerta, updatedAlerta);
        return "El registro ha sido actualizado";
    }
}
