/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.entity;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author fetec
 */
@Entity
@Table(name = "historial")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Historial.findAll", query = "SELECT h FROM Historial h"),
    @NamedQuery(name = "Historial.findByIdHistorial", query = "SELECT h FROM Historial h WHERE h.idHistorial = :idHistorial"),
    @NamedQuery(name = "Historial.findByDivisa", query = "SELECT h FROM Historial h WHERE h.divisa = :divisa"),
    @NamedQuery(name = "Historial.findByValor", query = "SELECT h FROM Historial h WHERE h.valor = :valor"),
    @NamedQuery(name = "Historial.findByTipoTransaccion", query = "SELECT h FROM Historial h WHERE h.tipoTransaccion = :tipoTransaccion"),
    @NamedQuery(name = "Historial.findByFechaAbrio", query = "SELECT h FROM Historial h WHERE h.fechaAbrio = :fechaAbrio"),
    @NamedQuery(name = "Historial.findByFechaCerro", query = "SELECT h FROM Historial h WHERE h.fechaCerro = :fechaCerro"),
    @NamedQuery(name = "Historial.findByPuntos", query = "SELECT h FROM Historial h WHERE h.puntos = :puntos")})
public class Historial implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_historial")
    private Integer idHistorial;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 11)
    @Column(name = "divisa")
    private String divisa;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "valor")
    private Double valor;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 11)
    @Column(name = "tipo_transaccion")
    private String tipoTransaccion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_abrio")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaAbrio;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_cerro")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaCerro;
    @Basic(optional = false)
    @NotNull
    @Column(name = "puntos")
    private double puntos;
    @JoinColumn(name = "id_usuario", referencedColumnName = "id_usuario")
    @ManyToOne(optional = false)
    private Usuarios idUsuario;

    public Historial() {
    }

    public Historial(Integer idHistorial) {
        this.idHistorial = idHistorial;
    }

    public Historial(Integer idHistorial, String divisa, String tipoTransaccion, Date fechaAbrio, Date fechaCerro, double puntos) {
        this.idHistorial = idHistorial;
        this.divisa = divisa;
        this.tipoTransaccion = tipoTransaccion;
        this.fechaAbrio = fechaAbrio;
        this.fechaCerro = fechaCerro;
        this.puntos = puntos;
    }

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

    public double getPuntos() {
        return puntos;
    }

    public void setPuntos(double puntos) {
        this.puntos = puntos;
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
        hash += (idHistorial != null ? idHistorial.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Historial)) {
            return false;
        }
        Historial other = (Historial) object;
        if ((this.idHistorial == null && other.idHistorial != null) || (this.idHistorial != null && !this.idHistorial.equals(other.idHistorial))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.entity.Historial[ idHistorial=" + idHistorial + " ]";
    }
    
}
