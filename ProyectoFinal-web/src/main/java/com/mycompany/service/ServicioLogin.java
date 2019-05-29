/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.service;

import com.mycompany.beans.CrudDivisasLocal;
import com.mycompany.beans.CrudSaldosLocal;
import com.mycompany.beans.CrudUsuariosLocal;
import com.mycompany.entity.Usuarios;
import com.mycompany.pojos.PojoDivisa;
import com.mycompany.pojos.PojoLogin;
import com.mycompany.pojos.PojoSaldo;
import com.mycompany.pojos.PojoUsuario;
import com.mycompany.utilitarios.Token;
import java.io.Serializable;
import java.net.URI;
import javax.ejb.EJB;
import javax.json.Json;
import javax.json.JsonObject;
import javax.ws.rs.BadRequestException;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

/**
 *
 * @author fetec
 */
@javax.enterprise.context.RequestScoped
@Path("login")
public class ServicioLogin implements Serializable{
    
    @EJB
    CrudUsuariosLocal user;
    
    @EJB
    CrudSaldosLocal saldo;
    
    @EJB
    CrudDivisasLocal divisa;
    
    @GET
    @Path("/{user},{pass}")    
    public Response validarLogin(@PathParam("user") String user, @PathParam("pass") String pass) {
        Usuarios u=new Usuarios();
        //u=usuario.validarLogin(user, pass);
        if(u!=null) {
                JsonObject json = Json.createObjectBuilder()
                                      .add("tokenauto", Token.generarToken(u.getNombre(),u.getCorreo()))
                                      .build();                
                //return Response.status(Response.Status.OK).entity(json).build();
                System.out.println(json);
                return Response.ok(json).build();
        } else {
                JsonObject json = Json.createObjectBuilder()
                                      .add("mensaje", "credenciales incorrectas")
                                      .build();
                return Response.status(Response.Status.UNAUTHORIZED).entity(json).build();
                
        }
    }
    
    @GET
    //@Produces(MediaType.APPLICATION_JSON)
    @Path("/{token}")    
    public Response desencriptar(@PathParam("token") String token) {
        
        //Token.imprimirEstructura(token);
        Token.imprimirBody(token);
        return Response.ok().build();                

    }
    
    @GET
    @Path("registro")    
    public Response registrar() {
        
        PojoDivisa d=new PojoDivisa();        
        d.setIdDivisa(2);
        d.setValor(1.7D);
        d.setDivisa("EUR/USD");
        divisa.editarDivisa(d);
        
        return Response.ok().build();            
    }
    
    @Context
    private UriInfo uriInfo;
    
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("registroUsuario")
    public Response registrarUsuario(PojoUsuario p) {
        JsonObject json;
        if(p == null){
            json = Json.createObjectBuilder()
                                      .add("Error", "Está nulo")
                                      .build();
        }else{
            System.out.println(p.getCorreo());
            user.agregarUsuario(p);
            json = Json.createObjectBuilder()
                                      .add("Está bien", "NO Está nulo")
                                      .build();
        }
        return Response.status(Response.Status.OK).entity(json).build();           
    }
    
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("registroDivisa")
    public Response registrarDivisa(PojoDivisa p) {
        JsonObject json;
        if(p == null){
            json = Json.createObjectBuilder()
                                      .add("Error", "Está nulo")
                                      .build();
        }else{
            System.out.println(p.getDivisa());
            divisa.agregarDivisa(p);
            json = Json.createObjectBuilder()
                                      .add("Está bien", "NO Está nulo")
                                      .build();
        }
        return Response.status(Response.Status.OK).entity(json).build();           
    }
    
    @GET
    @Path("entrar")
    public Response login(PojoLogin pl) {
        JsonObject json;
        if(pl == null){
            json = Json.createObjectBuilder()
                                      .add("Error", "Está nulo")
                                      .build();
        }else{
            json = Json.createObjectBuilder()
                                      .add("Está bien", "NO Está nulo")
                                      .build();
        //user.agregarUsuario(p);
 
        //Build a uri with the Item id appended to the absolute path
        //This is so the client gets the Item id and also has the path to the resource created
        //URI itemUri = uriInfo.getAbsolutePathBuilder().path(p.getClave()).build();
        }
 
        //The created response will not have a body. The itemUri will be in the Header
        return Response.status(Response.Status.OK).entity(json).build();           
    }
}
