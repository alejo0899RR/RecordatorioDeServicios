package com.eis.alertasApp.controllers;

import com.eis.alertasApp.models.Contrato;
import com.eis.alertasApp.models.Servicio;
import com.eis.alertasApp.services.ContratoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class ContratoController {
    @Autowired
    private ContratoService contratoService;

    @GetMapping("/contratos")
    public List<Contrato> getAll()
    {
        return contratoService.getAllContratos();
    }

    @GetMapping("/contratos/{id}")
    public Optional<Contrato> getContratosById(@PathVariable(value="id") Integer id_contrato)
    {
        return contratoService.getContratoById(id_contrato);
    }

    @PostMapping("/contratos")
    public String saveContrato(@RequestBody Contrato contrato)
    {
        contratoService.saveContrato(contrato);
        return "Exito del registro";
    }

    @DeleteMapping("/contratos/{id}")
    public String deleteContrato(@PathVariable(value="id") Integer id_contrato) {
        contratoService.deleteContratoById(id_contrato);
        return "Registro eliminado correctamente";
    }

    @PutMapping("/contratos/{id}")
    public String updateContratos(@PathVariable(value="id") Integer id_contrato, @RequestBody Contrato updatedContrato) {
        contratoService.updateContrato(id_contrato, updatedContrato);
        return "El registro ha sido actualizado";
    }
}
