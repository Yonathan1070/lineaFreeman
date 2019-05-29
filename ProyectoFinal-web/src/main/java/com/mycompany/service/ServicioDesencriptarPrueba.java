/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.service;

import com.mycompany.utilitarios.Token;
import java.io.Serializable;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

/**
 *
 * @author fetec
 */
@javax.enterprise.context.RequestScoped
@Path("desencriptar")
public class ServicioDesencriptarPrueba implements Serializable{
    
    @GET
    //@Produces(MediaType.APPLICATION_JSON)
    @Path("/{token}")    
    public Response desencriptar(@PathParam("token") String token) {
        
        Token.imprimirEstructura(token);
        Token.imprimirBody(token);
        return Response.ok().build();                

    }
}
