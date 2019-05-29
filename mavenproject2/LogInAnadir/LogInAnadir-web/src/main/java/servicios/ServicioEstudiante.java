/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicios;



import com.mycompany.MateriaDtoLocal;
import com.mycompany.UsuarioDtoLocal;
import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import pojos.Materia;

/**
 *
 * @author ASUS-PC
 */

@javax.enterprise.context.RequestScoped
@Path("estudiante")
public class ServicioEstudiante {
    @EJB
    MateriaDtoLocal materiaDto;
    UsuarioDtoLocal usuarioDto;
    
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response listarEstudiantes() {
        return Response.status(Response.Status.OK).build();
    }
    
    /*@GET
    @Path("/guardar/guardar")
    @Produces(MediaType.APPLICATION_JSON)
    public Response guardar() {
        try {
            usuarioDto.guardarDatos();
            return Response.status(Response.Status.OK).build();
        } catch (Exception ex) {
            System.err.println("********************************************");
            System.err.println("Error: " + ex.getMessage() + " " + ex.getCause().getMessage());
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
        }        
    }*/
    
        
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{id}")
    public Response estudianteEspecifico(@PathParam("id") int idMateria) {
        return Response.status(Response.Status.OK).entity(materiaDto.getMAteriaEspecifica(idMateria)).build();
    }
    
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response guardarMateria(Materia materia) {
        materiaDto.getListaMateria().add(materia);
        //return Response.status(Response.Status.OK).build();
        return Response.status(Response.Status.OK).entity(materia).build();
    }
    
}
