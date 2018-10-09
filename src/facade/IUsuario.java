/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

/**
 *
 * @author Vanessa
 */
public interface IUsuario {
    public String adicionar(String nombre, String correo, String contraseña) throws Exception;

    public String modificar(String correo, String nombre, String contraseña) throws Exception;

    public String consultar() throws Exception;
    
    public String getNombre() ;

  public void setNombre(String nombre);

  public String getCorreo();

  public void setCorreo(String correo);

  public String getContraseña();

  public void setContraseña(String contraseña);
    
    
}
