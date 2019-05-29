/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.beans;

import com.mycompany.entity.Divisas;
import com.mycompany.entity.Usuarios;
import com.mycompany.pojos.PojoDivisa;
import javax.ejb.Local;

/**
 *
 * @author fetec
 */
@Local
public interface CrudDivisasLocal {
    
    public void agregarDivisa(PojoDivisa d);
    public void editarDivisa(PojoDivisa d);
    public void eliminarDivisa(int i);
}
