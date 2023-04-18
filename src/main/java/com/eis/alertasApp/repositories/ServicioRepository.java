package com.eis.alertasApp.repositories;

import com.eis.alertasApp.models.Servicio;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 *
 * @author alejo
 */
@Repository
public interface ServicioRepository extends CrudRepository<Servicio, Integer> {
    @Override
    List <Servicio> findAll();
}
