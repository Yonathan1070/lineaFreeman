/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicios;


import java.io.IOException;
import javax.json.Json;
import javax.json.JsonObject;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.container.PreMatching;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.Provider;

/**
 
 * @author ASUS-PC
 */
@Provider
@PreMatching
public class Interceptor implements ContainerRequestFilter{

    @Override
    public void filter(ContainerRequestContext requestContext) throws IOException {
        String url = requestContext.getUriInfo().getAbsolutePath().toString();
        if(url.contains("api/autho"))
            return;
        String token =  requestContext.getHeaderString("token-auto");
        if(token == null) {
                JsonObject json = Json.createObjectBuilder()
                                      .add("mensaje", "token requerido")
                                      .build();                
                requestContext.abortWith(Response.status(Response.Status.UNAUTHORIZED)
                                                 .entity(json)
                                                 .type(MediaType.APPLICATION_JSON)
                                                 .build());
                
        } else if(!token.equals("1a324910ae9b8b3a3b684cb535f21e956b9712eac7e04e87f71ef4aa0c177b1d")) {
                JsonObject json = Json.createObjectBuilder()
                                      .add("mensaje", "token incorrecto")
                                      .build();                
                requestContext.abortWith(Response.status(Response.Status.UNAUTHORIZED)
                                                    .entity(json)
                                                    .type(MediaType.APPLICATION_JSON)
                                                    .build());                  
        }
    }    
}
