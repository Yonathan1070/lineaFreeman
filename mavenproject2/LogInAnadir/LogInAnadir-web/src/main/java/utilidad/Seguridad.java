/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utilidad;


import java.nio.charset.StandardCharsets;
import org.apache.commons.codec.digest.DigestUtils;

/**
 *
 * @author ASUS-PC
 */
public class Seguridad {

    
    
    public static String convertToHash(String usuario, String contrasena) {
        	        
        String cadena = usuario + contrasena + System.currentTimeMillis();
        String sha256hex = DigestUtils.sha256Hex(cadena);
        System.err.println("*******************************");
        System.err.println(sha256hex);       
        return sha256hex;
    }
}
