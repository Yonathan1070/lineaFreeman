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
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author fetec
 */
@Entity
@Table(name = "divisas")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Divisas.findAll", query = "SELECT d FROM Divisas d"),
    @NamedQuery(name = "Divisas.findByIdDivisa", query = "SELECT d FROM Divisas d WHERE d.idDivisa = :idDivisa"),
    @NamedQuery(name = "Divisas.findByDivisa", query = "SELECT d FROM Divisas d WHERE d.divisa = :divisa"),
    @NamedQuery(name = "Divisas.findByValor", query = "SELECT d FROM Divisas d WHERE d.valor = :valor")})
public class Divisas implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_divisa")
    private Integer idDivisa;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "divisa")
    private String divisa;
    @Basic(optional = false)
    @NotNull
    @Column(name = "valor")
    private double valor;

    public Divisas() {
    }

    public Divisas(Integer idDivisa) {
        this.idDivisa = idDivisa;
    }

    public Divisas(Integer idDivisa, String divisa, double valor) {
        this.idDivisa = idDivisa;
        this.divisa = divisa;
        this.valor = valor;
    }

    public Integer getIdDivisa() {
        return idDivisa;
    }

    public void setIdDivisa(Integer idDivisa) {
        this.idDivisa = idDivisa;
    }

    public String getDivisa() {
        return divisa;
    }

    public void setDivisa(String divisa) {
        this.divisa = divisa;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idDivisa != null ? idDivisa.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Divisas)) {
            return false;
        }
        Divisas other = (Divisas) object;
        if ((this.idDivisa == null && other.idDivisa != null) || (this.idDivisa != null && !this.idDivisa.equals(other.idDivisa))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.entity.Divisas[ idDivisa=" + idDivisa + " ]";
    }
    
}
