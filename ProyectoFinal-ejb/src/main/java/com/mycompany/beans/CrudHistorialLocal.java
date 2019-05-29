/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.beans;

import com.mycompany.entity.Historial;
import com.mycompany.pojos.PojoHistorial;
import javax.ejb.Local;

/**
 *
 * @author fetec
 */
@Local
public interface CrudHistorialLocal {
    
    public void agregarHistorial(PojoHistorial h);
    public void editarHistorial(PojoHistorial h);
    public void eliminarHistorial(int i);
}
