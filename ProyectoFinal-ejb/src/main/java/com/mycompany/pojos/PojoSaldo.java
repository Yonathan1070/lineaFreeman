/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.pojos;

import java.io.Serializable;

/**
 *
 * @author fetec
 */
public class PojoSaldo implements Serializable{
    
    private int idSaldo;
    private Double saldoActual;
    private Double saldoTemporal;
    private int idUsuario;

    public int getIdSaldo() {
        return idSaldo;
    }

    public void setIdSaldo(int idSaldo) {
        this.idSaldo = idSaldo;
    }

    public Double getSaldoActual() {
        return saldoActual;
    }

    public void setSaldoActual(Double saldoActual) {
        this.saldoActual = saldoActual;
    }

    public Double getSaldoTemporal() {
        return saldoTemporal;
    }

    public void setSaldoTemporal(Double saldoTemporal) {
        this.saldoTemporal = saldoTemporal;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }
    
    
}
