/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Random;
import javax.swing.JOptionPane;

/**
 *
 * @author Vanessa
 */
public class ProxyMenu implements Imenu{
    private Facade facade;
    private static ProxyMenu proxymenu  = null;
    private HashMap<String,IUsuario> usuarios;

    public ProxyMenu(){
        facade= new Facade();
        usuarios = new HashMap<String,IUsuario>();
    }
    
    public static ProxyMenu UnicaInstancia(){
        if(proxymenu == null){
            proxymenu = new ProxyMenu();
        }
        
        return proxymenu;
    }
    
    @Override
    public ArrayList<String> acceder(String correo, String contraseña) throws Exception {
        long id = new Random().nextLong();
        IUsuario usuario = facade.acceder(correo, contraseña, id);
        String menu, tipoUsuario;
        
        
        if(usuario instanceof Pasajero){
            menu = "elija una opcion: \n"
                    + "1) CREAR UNA RESERVA \n"
                    + "2) LISTAR MIS RESERVAS \n"
                    + "3) MODIFICAR RESERVA\n"
                    + "4) ELIMINAR UNA RESERVA \n"
                    + "5) REALIZAR PAGO CON CUENTA DEBITO \n"
                    + "6) REALIZAR PAGO CON CREDITO \n"                    
                    + "0) SALIR";
            tipoUsuario = "pasajero";
           
        }else if(usuario instanceof Conductor){
            menu = "elige una opcion\n"
                    + "1) CREAR RUTA\n"
                    + "2) LISTA DE MIS RUTAS  \n"
                    + "3) ACTUALIZAR DATOS DE UNA RUTA \n"
                    + "4) ELIMINAR UNA RUTA \n"
                    + "0) SALIR";
            tipoUsuario = "conductor";
        }else if(usuario instanceof AdministradorAdapter){
            menu = "elige una opcion\n"
                    + "1) REGISTRAR UN USUARIO\n"
                    + "2) LISTAR RUTAS POR CONDUCTOR\n"
                    + "3) LISTAR RESERVAS POR PASAJERO\n"
                    + "4) ELIMINAR UN USUARIO\n";
            tipoUsuario = "administrador";
        }else{
            throw new Exception("error en el ingreso");
        }
        ArrayList<String> datos =  new ArrayList();
        datos.add(menu); 
        datos.add(new Long(id).toString()); 
        datos.add(tipoUsuario);
        datos.add(correo);
        return datos;
        
    }
    

    @Override
    public void registrarUsuario(String tipoUsuario, String nombre, String correo, String contraseña) throws Exception {
        if(usuarios.get(correo)== null){
            usuarios.put(correo, facade.RegistrarUsuario(tipoUsuario, nombre, correo, contraseña));
        }else{
            throw new Exception ("este usuario ya se encuentra registrado");
        }
    }
    
    public void adicionar(String st, Usuario us){
        usuarios.put(st, us);
    }
    public Usuario buscar (String key){
        return (Usuario) usuarios.get(key);
    }
    public boolean actualizar (String key, Usuario u){
        Usuario resultado= null;
        resultado= (Usuario) usuarios.get(key);
        if(resultado== null){
            return false;
        }else{
            return true;
        }
    }
    public void eliminar (String key){
        usuarios.remove(key);
    }
  
    
    
    //-------------------------

    public Facade getFacade() {
        return facade;
    }

    public void setFacade(Facade facade) {
        this.facade = facade;
    }
   
    

    
   
}
