/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.pojos;

import java.io.Serializable;
import java.util.List;

/**
 *
 * @author fetec
 */
public class PojoUsuario implements Serializable{
    
    private int id;
    private String nombre;
    private String nombreUsuario;
    private String clave;
    private String correo;
    private String rutaFoto;
    private int idRol;
    private int estado;
    private String token;
    private List<PojoHistorial>historialList;
    private List<PojoSaldo>saldoList;

    public List<PojoHistorial> getHistorialList() {
        return historialList;
    }

    public void setHistorialList(List<PojoHistorial> historialList) {
        this.historialList = historialList;
    }

    public List<PojoSaldo> getSaldoList() {
        return saldoList;
    }

    public void setSaldoList(List<PojoSaldo> saldoList) {
        this.saldoList = saldoList;
    }    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getRutaFoto() {
        return rutaFoto;
    }

    public void setRutaFoto(String rutaFoto) {
        this.rutaFoto = rutaFoto;
    }

    public int getIdRol() {
        return idRol;
    }

    public void setIdRol(int idRol) {
        this.idRol = idRol;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
    
    
}
