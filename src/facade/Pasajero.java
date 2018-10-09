package facade;

public class Pasajero extends Usuario {

  public Pasajero() {
    super();
  }

    
    @Override
  public String adicionar(String nombre, String correo, String contraseña) throws Exception {
      if(getNombre()==null && getCorreo()==null && getContraseña()==null){
      setNombre(nombre);
      setCorreo(correo);
      setContraseña(contraseña);
      }else{
          throw new Exception("Este usuario ya tiene datos registrados");
      }
      
      return "Pasajero añadido exitósamente.";
    
  }

  @Override
  public String modificar(String correo, String nombre, String contraseña) throws Exception{
      
      if(!(getNombre()==null && getCorreo()==null && getContraseña()==null)) {
      setNombre(nombre);
      setCorreo(correo);
      setContraseña(contraseña);
      }else{
          throw new Exception("Este usuario no tiene datos registrados aun, deberias crearlo");
      }

      return "Pasajero modificado exitósamente.";
    
  }

  @Override
  public String consultar()  throws Exception {
      if(getNombre()==null && getCorreo()==null && getContraseña()==null){
          throw new Exception ("no hay datos guardados en este Usuario");
      }
      
      return "Pasajero: Nombre: " + getNombre() + " - correo: " + getCorreo();
    
  }

 

}
