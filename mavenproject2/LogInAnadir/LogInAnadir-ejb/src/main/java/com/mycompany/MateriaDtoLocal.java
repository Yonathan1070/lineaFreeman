/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany;

import java.util.List;
import javax.ejb.Local;
import pojos.Materia;

/**
 *
 * @author Familia
 */
@Local
public interface MateriaDtoLocal {
    public List<Materia> getListaMateria();
    public Materia getMAteriaEspecifica(int idMateria);
    public void setListaMateria(List<Materia> listaMateria);
}
