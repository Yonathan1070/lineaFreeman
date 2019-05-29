/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany;

import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import pojos.Materia;

/**
 *
 * @author Familia
 */
@Stateless
public class MateriaDto implements MateriaDtoLocal {
 List<Materia> listaMateria;
    
    public MateriaDto() {
        listaMateria = new ArrayList<>();
        listaMateria.add(new Materia(1, "Matematicas"));
        listaMateria.add(new Materia(2, "Físcia"));
        listaMateria.add(new Materia(3, "Biolgia"));
    }

 @Override
    public List<Materia> getListaMateria() {
        return listaMateria;
    }
    
 @Override
    public Materia getMAteriaEspecifica(int idMateria) {
        for (Materia lista : listaMateria) {
            if(lista.getId() == idMateria) {
                return lista;
            }
        }
        return null;
    }
    

 @Override
    public void setListaMateria(List<Materia> listaMateria) {
        this.listaMateria = listaMateria;
    }


}
