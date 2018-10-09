package facade;

public class Conductor extends Usuario {

  public Conductor() {
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
      
      return "Conductor añadido exitósamente.";
    
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

      return "COnductor modificado exitósamente.";
    
  }

  @Override
  public String consultar()  throws Exception {
      if(getNombre()==null && getCorreo()==null && getContraseña()==null){
          throw new Exception ("no hay datos guardados en este Usuario");
      }
      
      return "Conductor: Nombre: " + getNombre() + " - correo: " + getCorreo();
    
  }


}
