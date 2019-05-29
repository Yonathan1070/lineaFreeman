/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pojos;

import java.io.Serializable;

/**
 *
 * @author ASUS-PC
 */
public class Usuario implements Serializable{
    
    private String usuario;
    private String contrasena;
    private String token;

    public Usuario() {
    
    }
    
    public Usuario(String usuario, String contrasena, String token) {
        this.usuario = usuario;
        this.contrasena = contrasena;
        this.token = token;
    }
    public Usuario(String usuario, String contrasena) {
        this.usuario = usuario;
        this.contrasena = contrasena;
        //this.token = token;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
                    
}
