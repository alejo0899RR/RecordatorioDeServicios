package com.eis.alertasApp.models;

import javax.persistence.*;
import java.util.Date;


@Entity
@Table(name = "alertas")
public class Alerta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id_alerta;
    @Temporal(TemporalType.DATE)
    Date fecha;
    @ManyToOne
    @JoinColumn(name = "id_contrato")
    private Contrato contrato;
    @Temporal(TemporalType.DATE)
    Date fecha_pago;

    public Alerta() {
    }

    public Alerta(Date fecha, Contrato contrato, Date fecha_pago) {
        this.fecha = fecha;
        this.contrato = contrato;
        this.fecha_pago = fecha_pago;
    }

    public Integer getId_alerta() {
        return id_alerta;
    }

    public void setId_alerta(Integer id_alerta) {
        this.id_alerta = id_alerta;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Contrato getContrato() {
        return contrato;
    }

    public void setContrato(Contrato contrato) {
        this.contrato = contrato;
    }

    public Date getFecha_pago() {
        return fecha_pago;
    }

    public void setFecha_pago(Date fecha_pago) {
        this.fecha_pago = fecha_pago;
    }
}
