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
public interface Imenu {
    public ArrayList<String> acceder(String correo, String contraseña) throws Exception;
    public void registrarUsuario(String tipoUsuario, String nombre, String correo, String contraseña) throws Exception;
}
