package com.eis.alertasApp.models;

import javax.persistence.*;

@Entity
@Table(name = "contratos")
public class Contrato {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id_contrato;
    String descripcion;
    @ManyToOne
    @JoinColumn(name = "id_servicio")
    private Servicio servicio;
    int valor;
    int fecha;

    public Contrato() {
    }

    public Contrato(String descripcion, Servicio servicio, int valor, int fecha) {
        this.descripcion = descripcion;
        this.servicio = servicio;
        this.valor = valor;
        this.fecha = fecha;
    }

    public Integer getId_contrato() {
        return id_contrato;
    }

    public void setId_contrato(Integer id_contrato) {
        this.id_contrato = id_contrato;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Servicio getServicio() {
        return servicio;
    }

    public void setServicio(Servicio servicio) {
        this.servicio = servicio;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    public int getFecha() {
        return fecha;
    }

    public void setFecha(int fecha) {
        this.fecha = fecha;
    }
}
