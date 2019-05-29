/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import pojos.Usuario;

/**
 *
 * @author Familia
 */
@Stateless
public class UsuarioDto implements UsuarioDtoLocal {
private List<Usuario> listaUsuario;
    
      public UsuarioDto(){
          listaUsuario = new ArrayList<Usuario>();
          listaUsuario.add(new Usuario("johans", "1234", null));
      }
      

      public void guardarDatos()throws Exception{
        
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("C:\\Users\\ASUS-PC\\Desktop\\historial.txt"));
            oos.writeObject(listaUsuario);
            oos.close();
                    
    }
}
