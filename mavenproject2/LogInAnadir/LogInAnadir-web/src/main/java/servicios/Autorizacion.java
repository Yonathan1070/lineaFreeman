/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicios;


import javax.ejb.Stateless;
import javax.json.Json;
import javax.json.JsonObject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import pojos.Usuario;
import utilidad.Seguridad;

/**
 *
 * @author ASUS-PC
 */
@javax.enterprise.context.RequestScoped
@Path("autho")
public class Autorizacion {

    
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON) 
    public Response validarEstudiante(Usuario usuario) {
        
        if(usuario.getUsuario().equals("johans") && usuario.getContrasena().equals("1234")) {
                JsonObject json = Json.createObjectBuilder()
                                      .add("token-auto", Seguridad.convertToHash(usuario.getUsuario(), usuario.getContrasena()))
                                      .build();                
                //return Response.status(Response.Status.OK).entity(json).build();
                return Response.ok(json).build();
        } else {
                JsonObject json = Json.createObjectBuilder()
                                      .add("mensaje", "credenciales incorrectas")
                                      .build();
                return Response.status(Response.Status.UNAUTHORIZED).entity(json).build();
                
        }
    }
}
