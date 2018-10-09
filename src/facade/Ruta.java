/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import java.sql.Time;
import java.util.ArrayList;

/**
 *
 * @author Vanessa
 */
public final class Ruta implements Componente{
    private String nombre;
    private ArrayList<Componente> componentes;
    private String conductor;
    private String salida;
    private int pasajeros;

    public Ruta() {
        setNombre("");
        setComponentes(new ArrayList());
    }

    public Ruta(String nombre, String conductor, String salida, int pasajeros) {
        setNombre(nombre);
        setConductor(conductor);
        setSalida(salida);
        setPasajeros(pasajeros);
        setComponentes(new ArrayList());
    }

    public String getConductor() {
        return conductor;
    }

    public void setConductor(String conductor) {
        this.conductor = conductor;
    }
    
    
    

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public ArrayList<Componente> getComponentes() {
        return componentes;
    }

    public void setComponentes(ArrayList<Componente> componentes) {
        this.componentes = componentes;
    }
    
    public void add(Componente c){
        getComponentes().add(c);
    }

    @Override
    public String mostrarDatos() {
        System.out.println("Nombre Ruta: " + nombre);
        String s= "Nombre Ruta: " + nombre + "\n";
        for(Componente c : componentes) s = s + c.mostrarDatos();
        
        return s;
    }

    public String getSalida() {
        return salida;
    }

    public void setSalida(String salida) {
        this.salida = salida;
    }

    public int getPasajeros() {
        return pasajeros;
    }

    public void setPasajeros(int pasajeros) {
        this.pasajeros = pasajeros;
    }
    
    
    
    
    
}
