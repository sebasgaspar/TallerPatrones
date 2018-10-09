package facade;

import java.util.ArrayList;

public abstract class Usuario implements IUsuario{

  protected String nombre;
  protected String correo;
  protected String contraseña;

  abstract public String adicionar(String nombre, String correo, String contraseña) throws Exception;

  abstract public String modificar(String correo, String nombre, String contraseña) throws Exception;

  abstract public String consultar() throws Exception;



  public String getNombre() {
    return nombre;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  public String getCorreo() {
    return correo;
  }

  public void setCorreo(String correo) {
    this.correo = correo;
  }

  public String getContraseña() {
    return contraseña;
  }

  public void setContraseña(String contraseña) {
    this.contraseña = contraseña;
  }
}
