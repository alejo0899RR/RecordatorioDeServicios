package com.eis.alertasApp.controllers;

import com.eis.alertasApp.models.Servicio;
import com.eis.alertasApp.repositories.ServicioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class ServicioController {
    @Autowired
    private ServicioRepository serviciorepository;
    @GetMapping("/servicios")
    public List<Servicio> getAll()
    {
        return serviciorepository.findAll();
    }
    @GetMapping("/servicios/{id}")
    public Optional<Servicio> getById(@PathVariable(value="id") Integer id)
    {
        return serviciorepository.findById(id);
    }
    @PostMapping("/servicios")
    public String save(@RequestBody Servicio s)
    {
        serviciorepository.save(s);
        return "ok";
    }
}
