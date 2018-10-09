/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author Vanessa
 */
public class Datos {
    private String menu;
    private long codigo;
    private String tipoUsuario;
    private String correo;
    
    public Datos(String menu, long codigo, String tipoUsuario, String correo) {
        this.menu = menu;
        this.codigo = codigo;
        this.tipoUsuario = tipoUsuario;
        this.correo = correo;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }
    
   
    
    
    
    public String getMenu() {
        return menu;
    }

    public void setMenu(String menu) {
        this.menu = menu;
    }

    public long getCodigo() {
        return codigo;
    }

    public void setCodigo(long codigo) {
        this.codigo = codigo;
    }

    public String getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(String tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }

    
    
    
    
    
}
