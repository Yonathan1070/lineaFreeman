/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.beans;


import com.mycompany.controladorEntity.DivisasJpaController;
import com.mycompany.controladorEntity.HistorialJpaController;
import com.mycompany.entity.Divisas;
import com.mycompany.entity.Historial;
import com.mycompany.pojos.PojoHistorial;
import javax.ejb.Stateless;
import org.modelmapper.ModelMapper;

/**
 *
 * @author fetec
 */
@Stateless
public class CrudHistorial implements CrudHistorialLocal {

    @Override
    public void agregarHistorial(PojoHistorial h) {
        try{
            ModelMapper modelMapper = new ModelMapper();
            Historial s = modelMapper.map(h, Historial.class);
            HistorialJpaController jpa= new HistorialJpaController();
            jpa.create(s);
        }catch(Exception e){
            System.out.println("Error: "+e.getMessage());
        }
    }

    @Override
    public void editarHistorial(PojoHistorial h) {
        ModelMapper modelMapper = new ModelMapper();
        Historial hi = modelMapper.map(h, Historial.class);
        try{
            Historial historial;
            HistorialJpaController jpa=new HistorialJpaController();
            historial=jpa.getEntityManager().getReference(Historial.class, hi.getIdHistorial());
            if(hi.getIdHistorial()!=null){
                historial.setIdHistorial(hi.getIdHistorial());
            }
            if(hi.getDivisa()!=null){
                historial.setDivisa(hi.getDivisa());
            }
            if(!hi.getValor().isNaN()){
                historial.setValor(hi.getValor());
            }
            if(hi.getTipoTransaccion()!=null){
                historial.setTipoTransaccion(hi.getTipoTransaccion());
            }
            if(!hi.getFechaAbrio().equals(null)){
                historial.setFechaAbrio(hi.getFechaAbrio());
            }
            if(!hi.getFechaCerro().equals(null)){
                historial.setFechaCerro(hi.getFechaCerro());
            }
            if(!h.getPuntos().isNaN()){
                historial.setValor(hi.getPuntos());
            }
            if(hi.getIdUsuario().getIdUsuario()!=null){
                historial.setIdUsuario(hi.getIdUsuario());
            }
            jpa.edit(historial);
        }catch(Exception ex){
            System.out.println("Ha ocurrido un error");
        }
    }

    @Override
    public void eliminarHistorial(int i) {
        try{
            HistorialJpaController jpa=new HistorialJpaController();
            jpa.destroy(i);
        }catch(Exception ex){
            System.out.println("Ha ocurrido un error");
        }
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    
}
