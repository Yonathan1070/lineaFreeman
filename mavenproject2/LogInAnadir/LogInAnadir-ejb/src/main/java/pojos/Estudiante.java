/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pojos;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ASUS-PC
 */
public class Estudiante implements Serializable{
    
    private int identificacion;
    private String nombre;
    private boolean activo;
    private List<Materia> listaMateria;
    private String[] vector = {"1", "2", "3", "4"};
    
    public Estudiante() {
        listaMateria = new ArrayList<>();
    }

    public Estudiante(int identificacion, String nombre, boolean activo) {
        this.identificacion = identificacion;
        this.nombre = nombre;
        this.activo = activo;
        listaMateria = new ArrayList<>();
    }

    public int getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(int identificacion) {
        this.identificacion = identificacion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    public List<Materia> getListaMateria() {
        return listaMateria;
    }

    public void setListaMateria(List<Materia> listaMateria) {
        this.listaMateria = listaMateria;
    }

    public String[] getVector() {
        return vector;
    }

    public void setVector(String[] vector) {
        this.vector = vector;
    }
    
    
    
    
}
