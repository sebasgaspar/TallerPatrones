/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author gaspar
 */
public class MenuPrincipal {
     public static void main(String[] args) {
     
         String tipo,correo,contraseña;
         ArrayList<String> datos;
         int op=0;
         do {
            try{
                op=Integer.parseInt(JOptionPane.showInputDialog("1.Registrar \n"
                     + "2.Acceder \n"
                     + "0. Salir"));
            
            switch(op)
            {
                case 1:
                   int opcion = Integer.parseInt(JOptionPane.showInputDialog(null, "Bienvenido, ¿Quién es usted?\n"
                    + "1. Conductor\n"
                    + "2. Pasajero\n"
                    + "3. Administrador\n"
                    + "4. Atras \n"
                    + "0. Salir"
            ));
                   
            switch (opcion) {
                case 1:
                    
                                correo = JOptionPane.showInputDialog("Correo: ");
                                contraseña = JOptionPane.showInputDialog("Clave: ");
                                tipo="conductor";
                                ProxyMenu.UnicaInstancia().registrarUsuario(tipo, "aa", correo, contraseña);
                                break;
                case 2:
                    
        
                                 correo = JOptionPane.showInputDialog("Correo: ");
                                 contraseña = JOptionPane.showInputDialog("Clave: ");
                                 tipo="pasajero";
                                ProxyMenu.UnicaInstancia().registrarUsuario(tipo,"aa", correo, contraseña);
                                break;
                            
                        
                case 3:
                   
                                 correo = JOptionPane.showInputDialog("Correo: ");
                                contraseña = JOptionPane.showInputDialog("Clave: ");
                                 tipo="administrador"; 
                                ProxyMenu.UnicaInstancia().registrarUsuario(tipo, "aa", correo, contraseña);
                                break;
                                
                case 4: 
                    break;
                    
            }
            break;
                case 2:
                        correo= JOptionPane.showInputDialog("ingrese su correo");
                           contraseña = JOptionPane.showInputDialog("ingrese su contraseña");
                        datos= ProxyMenu.UnicaInstancia().acceder(correo, contraseña);
                        mostrarMenu(datos);
                    break;
                    
                case 0:
                    JOptionPane.showMessageDialog(null, "Saliendo del sistema!","Despedida",2);
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "ESE CASO NO EXISTE..!","Error",0);
                    break;
                
            }
            }
            catch(Exception e)
            {
                JOptionPane.showMessageDialog(null, e, "Error", JOptionPane.ERROR_MESSAGE);
            }
         }while(op!=0);
     }
     
     private static void mostrarMenu(ArrayList<String> mensaje) throws Exception{
       String hora,ruta, pasajero, bruta, banco, tipocuenta, cuenta,conductor, tarjeta, codigo,salida;
       String tipo, nombre, correo, contraseña;
       long valor;
       int op=-1, cuotas,pasajeros, calles;
       do{
          op = Integer.parseInt(JOptionPane.showInputDialog(mensaje.get(0)));
          if(mensaje.get(2).equals("pasajero") ){
              pasajero = mensaje.get(3);
              switch(op){
                  case 1:
                      hora = JOptionPane.showInputDialog("ingresar la hora de la reserva");
                      ruta =JOptionPane.showInputDialog("ingresar el nombre de la ruta a reservar");
                      ProxyMenu.UnicaInstancia().getFacade().crearReserva(hora, ruta, pasajero);
                      break;
                  case 2:
                      JOptionPane.showMessageDialog(null, ProxyMenu.UnicaInstancia().getFacade().verReservas(pasajero));
                      break;
                  case 3:
                      bruta= JOptionPane.showInputDialog("Ingrese la anterior ruta de la reserva a modificar");
                      ruta= JOptionPane.showInputDialog("Ingrese la nueva ruta de la reserva a modificar");
                      hora= JOptionPane.showInputDialog("Ingrese la nueva hora de lareserva a modificar");
                      ProxyMenu.UnicaInstancia().getFacade().modificarReserva(bruta, ruta, hora,pasajero );
                  case 4:
                      ruta =JOptionPane.showInputDialog("Ingrese la ruta a la cual va a eliminar su reserva");
                      ProxyMenu.UnicaInstancia().getFacade().eliminarReserva(ruta, pasajero);
                      break;
                  case 5:
                      banco = JOptionPane.showInputDialog("Ingrese el banco al que pertenece su cuenta");
                      tipocuenta= JOptionPane.showInputDialog("ingrese el tipo de cuenta que tiene");
                      cuenta = JOptionPane.showInputDialog("ingrese el numero de la cuenta");
                      valor = Long.parseLong(JOptionPane.showInputDialog("ingrese el valor a pagar"));
                      conductor = JOptionPane.showInputDialog("ingrese el correo del conductor al cual le va a pagar");
                      ProxyMenu.UnicaInstancia().getFacade().PagoDebito(banco, tipocuenta, cuenta, valor, conductor, pasajero);
                      break;
                  case 6:
                      banco = JOptionPane.showInputDialog("ingrese el banco al cual pertenece su tarjeta");
                      tarjeta= JOptionPane.showInputDialog("ingrese el numero de su tarjeta");
                      codigo = JOptionPane.showInputDialog("Ingrese el codigo de seguridad");
                      cuotas = Integer.parseInt(JOptionPane.showInputDialog("ingrese el numero de cuotas"));
                      valor = Long.parseLong(JOptionPane.showInputDialog("ingrese le valor a pagar"));
                      conductor = JOptionPane.showInputDialog("ingrese el correo del conductor al cual le va a pagar");
                      ProxyMenu.UnicaInstancia().getFacade().PagoCredito(banco, tarjeta, codigo, cuotas, valor, conductor, pasajero);
                      break; 
              }
              
          }else if(mensaje.get(2).equals("conductor")){
              conductor = mensaje.get(3);
              switch(op){
                  case 1:
                      ruta= JOptionPane.showInputDialog("ingrese el nombre de la nueva ruta");
                      salida = JOptionPane.showInputDialog("Ingrese la hora de salida desu punto de origen");
                      pasajeros = Integer.parseInt(JOptionPane.showInputDialog("ingrese el numero de pasajeros"));
                      calles = Integer.parseInt(JOptionPane.showInputDialog("ingrese el numero de calles"));
                      ProxyMenu.UnicaInstancia().getFacade().crearRuta(ruta, salida, pasajeros, calles, conductor);
                      break;
                  case 2:
                      JOptionPane.showMessageDialog(null, ProxyMenu.UnicaInstancia().getFacade().listarRutas(conductor));
                      break;
                  case 3:
                      ruta = JOptionPane.showInputDialog("ingrese el nombre de la ruta a modificar");
                      salida = JOptionPane.showInputDialog("ingrese la nueva hora de salida");
                      pasajeros = Integer.parseInt(JOptionPane.showInputDialog("ingrese la nueva cantidad de pasajeros"));
                      ProxyMenu.UnicaInstancia().getFacade().modificarRuta(ruta, salida, pasajeros);
                      break;
                  case 4:
                      ruta = JOptionPane.showInputDialog("ingrese el nombre de la ruta a eliminar");
                      ProxyMenu.UnicaInstancia().getFacade().eliminarRuta(ruta);
                      break;
              }
              
          }else if(mensaje.get(2).equals("administrador")){
              switch(op){
                  case 1:
                      nombre= JOptionPane.showInputDialog("Nombre del usuario a crear");
                        correo= JOptionPane.showInputDialog("correo electronico");
                        contraseña = JOptionPane.showInputDialog("constraseña");
                        int t= Integer.parseInt(JOptionPane.showInputDialog("1. administrador\n2.pasajero\n3.conductor"));
                        switch(t){
                            case 1: tipo = "administrador"; break;
                            case 2: tipo = "pasajero"; break;
                            case 3: tipo = "conductor"; break;
                            default: tipo = null; break;
                        }
                        ProxyMenu.UnicaInstancia().registrarUsuario(tipo, nombre, correo, contraseña);
                        break;
                  case 2:
                      conductor = JOptionPane.showInputDialog("Ingrese el correo del condutor");
                      ProxyMenu.UnicaInstancia().getFacade().listarRutas(conductor);
                      break;
                  case 3:
                      pasajero = JOptionPane.showInputDialog("ingrese el correo del  pasajero");
                      ProxyMenu.UnicaInstancia().getFacade().verReservas(pasajero);
                      break;
                  case 4:
                      correo = JOptionPane.showInputDialog("ingrese el correo del usuario a eliminar");
                      ProxyMenu.UnicaInstancia().getFacade().eliminarUsuario(correo);
                      break;
              }
          }
          
          
       }while(op!=0  && ProxyMenu.UnicaInstancia().getFacade().verificarCodigo(mensaje.get(3), Long.parseLong(mensaje.get(1))));
   }
}
