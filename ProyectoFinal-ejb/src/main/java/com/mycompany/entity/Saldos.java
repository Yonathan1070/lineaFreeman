/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author fetec
 */
@Entity
@Table(name = "saldos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Saldos.findAll", query = "SELECT s FROM Saldos s"),
    @NamedQuery(name = "Saldos.findByIdSaldo", query = "SELECT s FROM Saldos s WHERE s.idSaldo = :idSaldo"),
    @NamedQuery(name = "Saldos.findBySaldoActual", query = "SELECT s FROM Saldos s WHERE s.saldoActual = :saldoActual"),
    @NamedQuery(name = "Saldos.findBySaldoTemporal", query = "SELECT s FROM Saldos s WHERE s.saldoTemporal = :saldoTemporal")})
public class Saldos implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_saldo")
    private Integer idSaldo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "saldo_actual")
    private double saldoActual;
    @Basic(optional = false)
    @NotNull
    @Column(name = "saldo_temporal")
    private double saldoTemporal;
    @JoinColumn(name = "id_usuario", referencedColumnName = "id_usuario")
    @ManyToOne(optional = false)
    private Usuarios idUsuario;

    public Saldos() {
    }

    public Saldos(Integer idSaldo) {
        this.idSaldo = idSaldo;
    }

    public Saldos(Integer idSaldo, double saldoActual, double saldoTemporal) {
        this.idSaldo = idSaldo;
        this.saldoActual = saldoActual;
        this.saldoTemporal = saldoTemporal;
    }

    public Integer getIdSaldo() {
        return idSaldo;
    }

    public void setIdSaldo(Integer idSaldo) {
        this.idSaldo = idSaldo;
    }

    public double getSaldoActual() {
        return saldoActual;
    }

    public void setSaldoActual(double saldoActual) {
        this.saldoActual = saldoActual;
    }

    public double getSaldoTemporal() {
        return saldoTemporal;
    }

    public void setSaldoTemporal(double saldoTemporal) {
        this.saldoTemporal = saldoTemporal;
    }

    public Usuarios getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Usuarios idUsuario) {
        this.idUsuario = idUsuario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idSaldo != null ? idSaldo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Saldos)) {
            return false;
        }
        Saldos other = (Saldos) object;
        if ((this.idSaldo == null && other.idSaldo != null) || (this.idSaldo != null && !this.idSaldo.equals(other.idSaldo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.entity.Saldos[ idSaldo=" + idSaldo + " ]";
    }
    
}
