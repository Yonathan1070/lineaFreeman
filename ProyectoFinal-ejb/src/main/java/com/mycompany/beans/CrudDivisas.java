/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.beans;

import com.mycompany.controladorEntity.DivisasJpaController;
import com.mycompany.controladorEntity.SaldosJpaController;
import com.mycompany.controladorEntity.UsuariosJpaController;
import com.mycompany.entity.Divisas;
import com.mycompany.entity.Saldos;
import com.mycompany.entity.Usuarios;
import com.mycompany.pojos.PojoDivisa;
import javax.ejb.Stateless;
import org.modelmapper.ModelMapper;

/**
 *
 * @author fetec
 */
@Stateless
public class CrudDivisas implements CrudDivisasLocal {

    @Override
    public void agregarDivisa(PojoDivisa d) {
        try{
            ModelMapper modelMapper = new ModelMapper();
            Divisas s = modelMapper.map(d, Divisas.class);
            DivisasJpaController jpa= new DivisasJpaController();
            jpa.create(s);
        }catch(Exception e){
            System.out.println("Error: "+e.getMessage());
        }
    }

    @Override
    public void editarDivisa(PojoDivisa d) {
        ModelMapper modelMapper = new ModelMapper();
        Divisas di = modelMapper.map(d, Divisas.class);
        try{
            Divisas divisa;
            DivisasJpaController jpa=new DivisasJpaController();
            divisa=jpa.getEntityManager().getReference(Divisas.class, di.getIdDivisa());
            if(di.getDivisa()!=null){
                divisa.setDivisa(di.getDivisa());
            }
            if(di.getIdDivisa()!=null){
                divisa.setIdDivisa(di.getIdDivisa());
            }
            if(!d.getValor().isNaN()){
                divisa.setValor(di.getValor());
            }            
            jpa.edit(divisa);
        }catch(Exception ex){
            System.out.println("Ha ocurrido un error");
        }
    }

    @Override
    public void eliminarDivisa(int i) {
        try{
            DivisasJpaController jpa=new DivisasJpaController();
            jpa.destroy(i);
        }catch(Exception ex){
            System.out.println("Ha ocurrido un error");
        }
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
