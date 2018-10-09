/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import java.util.ArrayList;

/**
 *
 * @author Vanessa
 */
public class DatosF {
    private long key;
    private String correo;
    private String accion;

    public DatosF(long key, String correo, String accion) {
        this.key = key;
        this.correo = correo;
        this.accion = accion;
    }

    public long getKey() {
        return key;
    }

    public void setKey(long key) {
        this.key = key;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getAccion() {
        return accion;
    }

    public void setAccion(String accion) {
        this.accion = accion;
    }

   
    
    
    
}
