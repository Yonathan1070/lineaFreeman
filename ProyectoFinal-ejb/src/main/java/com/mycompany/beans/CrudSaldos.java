/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.beans;

import com.mycompany.controladorEntity.SaldosJpaController;
import com.mycompany.controladorEntity.UsuariosJpaController;
import com.mycompany.entity.Saldos;
import com.mycompany.entity.Usuarios;
import com.mycompany.pojos.PojoSaldo;
import java.util.ArrayList;
import javax.ejb.Stateless;
import javax.validation.ConstraintViolationException;
import org.modelmapper.ModelMapper;

/**
 *
 * @author fetec
 */
@Stateless
public class CrudSaldos implements CrudSaldosLocal {

    @Override
    public void agregarSaldo(PojoSaldo s) {
        try{
            ModelMapper modelMapper = new ModelMapper();
            Saldos saldo = modelMapper.map(s, Saldos.class);
            SaldosJpaController jpa= new SaldosJpaController();
            jpa.create(saldo);
        }catch(Exception e){
            System.out.println("Error: "+e.getMessage());
        }
    }

    @Override
    public void editarSaldo(PojoSaldo s) {
        ModelMapper modelMapper = new ModelMapper();
        Saldos u = modelMapper.map(s, Saldos.class);
        try{
            Saldos saldo;
            SaldosJpaController jpa=new SaldosJpaController();
            saldo=jpa.getEntityManager().getReference(Saldos.class, u.getIdSaldo());
            if(u.getIdSaldo()!=null){
                saldo.setIdSaldo(u.getIdSaldo());
            }
            if(u.getIdUsuario().getIdUsuario().equals(saldo.getIdUsuario().getIdUsuario())){
                saldo.setIdUsuario(u.getIdUsuario());
            }
            if(!s.getSaldoActual().isNaN()){
                saldo.setSaldoActual(u.getSaldoActual());
            }
            if(!s.getSaldoTemporal().isNaN()){
                saldo.setSaldoTemporal(u.getSaldoTemporal());
            }
            jpa.edit(saldo);
        }catch(Exception ex){
            System.out.println("Ha ocurrido un error");
        }
    }

    @Override
    public void eliminarSaldo(int i) {
        try{
            SaldosJpaController jpa=new SaldosJpaController();
            jpa.destroy(i);
        }catch(Exception ex){
            System.out.println("Ha ocurrido un error");
        }
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
