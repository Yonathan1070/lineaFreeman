/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.beans;

import com.mycompany.controladorEntity.UsuariosJpaController;
import com.mycompany.entity.Usuarios;
import com.mycompany.pojos.PojoUsuario;
import javax.ejb.Stateless;
import javax.validation.ConstraintViolationException;
import org.modelmapper.ModelMapper;

/**
 *
 * @author fetec
 */
@Stateless
public class CrudUsuarios implements CrudUsuariosLocal {


    @Override
    public void agregarUsuario(PojoUsuario p) {
        try{
            ModelMapper modelMapper = new ModelMapper();
            Usuarios u = modelMapper.map(p, Usuarios.class);
            UsuariosJpaController jpa= new UsuariosJpaController();
            jpa.create(u);
        }catch(Exception e){
            System.out.println("Error: "+e.getMessage());
        }
    }

    @Override
    public Usuarios validarLogin(String user, String contrasena) {
        UsuariosJpaController jpa= new UsuariosJpaController();
        Usuarios u=new Usuarios();
        u=jpa.validarLogin(user, contrasena);
        if(u!=null){
            return u;
        }else
            return null;
    }

    @Override
    public void editarUsuario(PojoUsuario p) {
        ModelMapper modelMapper = new ModelMapper();
        Usuarios u = modelMapper.map(p, Usuarios.class);
        try{
            Usuarios user;
            UsuariosJpaController jpa=new UsuariosJpaController();
            user=jpa.getEntityManager().getReference(Usuarios.class, u.getIdUsuario());
            if(u.getIdUsuario()!=null){
                user.setIdUsuario(u.getIdUsuario());
            }
            if(u.getNombre()!=null){
                user.setNombre(u.getNombre());
            }
            if(u.getNombreUsuario()!=null){
                user.setNombreUsuario(u.getNombreUsuario());
            }
            if(u.getClave()!=null){
                user.setClave(u.getClave());
            }
            if(u.getCorreo()!=null){
                user.setCorreo(u.getCorreo());
            }
            if(u.getEstado()!=user.getEstado()){
                user.setEstado(u.getEstado());
            }
            if(u.getHistorialList()!=null){
                user.setHistorialList(u.getHistorialList());
            }
            if(u.getSaldosList()!=null){
                user.setSaldosList(u.getSaldosList());
            }
            if(u.getToken()!=null){
                user.setToken(u.getToken());
            }
            if(u.getRutaFoto()!=null){
                user.setRutaFoto(u.getRutaFoto());
            }
            if(user.getIdRol()!=u.getIdRol()){
                user.setIdRol(u.getIdRol());
            }            
            jpa.edit(user);
        }catch(Exception ex){
            System.out.println("Ha ocurrido un error");
        }
    }

    @Override
    public void eliminarUsuario(int i) {
        try{
            UsuariosJpaController jpa=new UsuariosJpaController();
            jpa.destroy(i);
        }catch(Exception ex){
            System.out.println("Ha ocurrido un error");
        }
    }
}
