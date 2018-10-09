/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import java.util.ArrayList;
import java.util.Iterator;
import javax.swing.JOptionPane;

/**
 *
 * @author Vanessa
 */
public class Facade {
    
    private ArrayList<Ruta> rutas;
    private ArrayList<Reserva> reservas ;
    private ArrayList<ComponentePagos> pagos;
    private Usuarios usuarios; 
    private ArrayList<Acceso> ingresos;
    
    public Facade(){
        usuarios = new Usuarios();
        reservas = new ArrayList<Reserva>();
        pagos = new ArrayList<ComponentePagos>();
        rutas = new ArrayList<Ruta>();
        ingresos = new ArrayList<Acceso>();
        
    }
    
   /*public String accion(ArrayList<String> datos) throws Exception{
       if(Long.parseLong(datos.get(0))== verificarCodigo(datos.get(1))){
           if(datos.get(2).equals("p1")){
               this.crearReserva(datos.get(3),datos.get(4), datos.get(1));
               return "reserva exitosa";
           }
           
           if(datos.get(2).equals("p2")){
               return this.verReservas(datos.get(1));
               
           }
           
           if(datos.get(2).equals("p3")){
               if(this.modificarReserva(datos.get(3), datos.get(4), datos.get(5), datos.get(1))) return "modificacion exitosa";
           }
           
           if(datos.get(2).equals("p4")){
               if(this.eliminarReserva(datos.get(3), datos.get(1))) return "reserva eliminada";
           }
           
           if(datos.get(2).equals("p5")){
               return this.PagoDebito(datos.get(3), datos.get(4), datos.get(5), Long.parseLong(datos.get(6)), datos.get(7), datos.get(1)).mostrarDatos();
           }
           if(datos.get(2).equals("p6")){
               return this.PagoCredito(datos.get(3), datos.get(4), datos.get(5),Integer.parseInt(datos.get(6)),Long.parseLong(datos.get(7)), datos.get(8), datos.get(1)).mostrarDatos();
           }
           throw new Exception ("accion invalida");
       }
       throw new Exception("Sesion invalida");
   } */
    
    public Usuario RegistrarUsuario(String tipo, String nombre, String correo, String contraseña) throws Exception{
        Usuario u;
        if(tipo.equals("conductor")){
            u= new Conductor();
        }else if(tipo.equals("pasajero")){
            u= new Pasajero();
        }else if(tipo.equals("administrador")){
            u = new AdministradorAdapter();
        }else{
            throw new Exception ("Tipo de usuario no especificado");
        }
        String r= u.adicionar(nombre, correo, contraseña);
        usuarios.putUsuario(u);
        return u;
    }
    
    public void eliminarUsuario(String correo){
        usuarios.removeUsuario(correo);
        ProxyMenu.UnicaInstancia().eliminar(correo);
    }
    
    public IUsuario acceder(String correo, String contraseña, long id) throws Exception{
        IUsuario user= usuarios.getUsuario(correo);
        if(user==null) throw new Exception("este usuario no esta registrado");
        
        if(user.getContraseña().equals(contraseña)){
            ingresos.add(new Acceso(correo, id));
            return user;
        }else{
            throw new Exception("Contraseña incorrecta");
        }
    }
    
    public Ruta crearRuta(String nombre, String salida, int pasajeros, int calles, String conductor) throws Exception{
        if(comprobarRuta(nombre)!= null) throw new Exception ("existe una ruta llamada así");
        Ruta r= new Ruta();
        r.setNombre(nombre);
        r.setSalida(salida);
        r.setPasajeros(pasajeros);
        r.setConductor(conductor);
        for(int i=0;i<calles;i++){
            String nombrec= JOptionPane.showInputDialog("ingrese el nombre de la calle");
            long coordenadaXorigen=Long.parseLong(JOptionPane.showInputDialog("ingrese la coordenada x del origen"));
            long coordenadaYorigen=Long.parseLong(JOptionPane.showInputDialog("ingrese la coordenada y del origen"));
            long coordenadaXdestino=Long.parseLong(JOptionPane.showInputDialog("ingrese la coordenada x del destino"));
            long coordenadaYdestino=Long.parseLong(JOptionPane.showInputDialog("ingrese la coordenada y del destino"));
            long distancia=Long.parseLong(JOptionPane.showInputDialog("ingrese la disntacia de la calle"));
            long tiempo=Long.parseLong(JOptionPane.showInputDialog("ingrese el tiempo empleado para recorrerla"));
            Componente c= crearCalle(coordenadaXorigen,coordenadaYorigen,coordenadaXdestino,coordenadaYdestino,nombrec,distancia, tiempo);
            r.add(c);
        }
        rutas.add(r);
        return r;
    }
    
    public String listarRutas(String conductor){
        String r = "nombre | conductor | hora de salida | n de pasajeros \n";
        Ruta ru;
        for (Componente c : rutas){
            if(c instanceof Ruta){
                ru = (Ruta) c;
                if(ru.getConductor().equals(conductor)){
                    r = r + ru.getNombre() + " | " + ru.getConductor() + " | " + ru.getSalida() + " | " + ru.getPasajeros() + "\n";
                }
            }
        }
        
        return r;
    }
    
   
    
    public boolean eliminarRuta(String nombre) throws Exception{
        Iterator it = rutas.iterator();
        Componente c;
        Ruta r;
        while(it.hasNext()){
            c = (Componente) it.next();
            if(c instanceof Ruta){
                r = (Ruta) c;
                if(r.getNombre().equals(nombre)){
                    rutas.remove(r);
                    return true;
                }
            }
        }
        
        throw new Exception ("no se pudo eliminar la ruta,porque no fue encontrada");
    }
    
    public boolean modificarRuta(String bnombre, String nsalida, int npasajeros) throws Exception{
        if(npasajeros<0) throw new Exception ("esta ruta no dispone de pasajeros");
        Ruta rut;
        for(Componente r : rutas){
            if(r instanceof Ruta){
                rut = (Ruta) r;
                if(rut.getNombre().equals(bnombre)){
                    rut.setSalida(nsalida);
                    rut.setPasajeros(npasajeros);
                    rutas.set(rutas.indexOf(r), (Ruta) (Componente) rut);
                    return true;
                }
            }
        }
        
        throw new Exception("no se ha podido modificar la ruta");
    }
    
    public void crearReserva(String hora, String ruta, String pasajero) throws Exception{
        if(comprobarRuta(ruta)== null) throw new Exception ("no existe esa ruta");
        Ruta r = (Ruta) comprobarRuta(ruta);
        modificarRuta(ruta,r.getSalida(),(r.getPasajeros()-1) );
        reservas.add(new Reserva(pasajero,ruta,hora));
    }
    
    public boolean modificarReserva(String bruta, String nruta, String hora,String pasajero) throws Exception{
        Reserva re;
        for(Reserva r : reservas){
            re = r;
            if(r.getRuta().equals(bruta) && r.getPasajero().equals(pasajero)){
                re.setHora(hora);
                re.setRuta(nruta);
                reservas.set(reservas.indexOf(r), re);
                return true;
            }
        }
        
        throw new Exception ( "no fue posible modificar la ruta");
    }
    
    public boolean eliminarReserva(String ruta, String pasajero) throws Exception{
        for(Reserva r: reservas){
            if(r.getPasajero().equals(pasajero) && r.getRuta().equals(ruta)){
                Ruta ru = (Ruta) comprobarRuta(ruta);
                modificarRuta(ruta,ru.getSalida(),(ru.getPasajeros()+1) );
                reservas.remove(r);
                return true;
            }
        }
        
        throw new Exception("no se encontro una reserva para eliminar");
    }
    
    public String verReservas(String pasajero){
        String r = "ruta | hora\n";
        for(Reserva re: reservas){
            if(re.getPasajero().equals(pasajero)){
                r = r + re.getRuta()+  " | " + re.getHora()+  "\n";
            }
        }
        return r;
    }
    
    public ComponentePagos pagoEfectivo(long valor, String conductor, String pasajero) throws Exception{
        ComponentePagos pago = new Pagos(); 
        pago.ingresarDatos(conductor +"," + pasajero +"," + valor);
        pagos.add(pago);
        return pago;
    }
    
    public ComponentePagos PagoCredito(String banco, String tarjeta, String codigo, int cuotas, long valor, String conductor, String pasajero) throws Exception{
        ComponentePagos val = new Pagos();
        val.ingresarDatos(conductor +"," + pasajero +"," + valor);
        ComponentePagos pago= new PagosPSECredito(val);
        pago.ingresarDatos(tarjeta +"," + codigo +"," + cuotas + "," +banco);
        pagos.add(pago);
        return pago;
    }
    
    public ComponentePagos PagoDebito(String banco,String tipocuenta, String cuenta, long valor, String conductor, String pasajero) throws Exception{
        ComponentePagos val = new Pagos();
        val.ingresarDatos(conductor +"," +pasajero  +"," + valor);
        ComponentePagos pago =new PagosPSECuenta(new Pagos());
        pago.ingresarDatos(tipocuenta +"," + cuenta + "," + banco);
        pagos.add(pago);
        return pago;
    }
    
    //-----------------------------------------metodos privados (para el funcionamiento de otros)-------------
    
    
      private Usuario buscarUsuario(String correo) throws Exception{
        IUsuario u = usuarios.getUsuario(correo);
        if(u == null){
            throw new Exception("Usuario no encontrado");
        }else{
            return (Usuario) u;
        }
    }
      
       private Componente crearCalle(Long coordenadaXorigen, Long coordenadaYorigen, Long coordenadaXdestino, Long coordenadaYdestino, String nombre, Long distancia, Long tiempo){
        return new Calle(coordenadaXorigen,coordenadaYorigen,coordenadaXdestino,coordenadaYdestino,nombre,distancia, tiempo);
    }
    
    private Ruta comprobarRuta(String nombre){
        for(Ruta c: rutas){
                if(c.getNombre().equals(nombre))  return c;    
        }
        return null;
    }
    
    public boolean verificarCodigo(String correo, long codigo) throws Exception{
        for(Acceso a: ingresos){
            if(a.getKey().equals(correo) && a.getId() == codigo){
                return true;
            }
        }
        
        throw new Exception("no ha iniciado sesion");
    }
}


