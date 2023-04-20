package com.eis.alertasApp.repositories;

import com.eis.alertasApp.models.Alerta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AlertasRepository extends JpaRepository<Alerta, Integer > {
}
