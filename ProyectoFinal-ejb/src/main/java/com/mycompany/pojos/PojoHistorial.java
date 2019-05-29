/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.pojos;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author fetec
 */
public class PojoHistorial implements Serializable{
    
    private Integer idHistorial;
    private String divisa;
    private Double valor;
    private String tipoTransaccion;
    private Date fechaAbrio;
    private Date fechaCerro;
    private Double puntos;
    private Integer idUsuario;

    public Integer getIdHistorial() {
        return idHistorial;
    }

    public void setIdHistorial(Integer idHistorial) {
        this.idHistorial = idHistorial;
    }

    public String getDivisa() {
        return divisa;
    }

    public void setDivisa(String divisa) {
        this.divisa = divisa;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public String getTipoTransaccion() {
        return tipoTransaccion;
    }

    public void setTipoTransaccion(String tipoTransaccion) {
        this.tipoTransaccion = tipoTransaccion;
    }

    public Date getFechaAbrio() {
        return fechaAbrio;
    }

    public void setFechaAbrio(Date fechaAbrio) {
        this.fechaAbrio = fechaAbrio;
    }

    public Date getFechaCerro() {
        return fechaCerro;
    }

    public void setFechaCerro(Date fechaCerro) {
        this.fechaCerro = fechaCerro;
    }

    public Double getPuntos() {
        return puntos;
    }

    public void setPuntos(Double puntos) {
        this.puntos = puntos;
    }

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    
    
    
}
