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
public class Calle implements Componente{

    private long coordenadaXorigen;
    private long coordenadaYorigen;
    private long coordenadaXdestino;
    private long coordenadaYdestino;
    private String nombre;
    private long distancia;
    private long tiempo;
    
    public String mostrarDatos() {
        System.out.println(
                "Nombre Calle: " + nombre + " Coordenadas origen: (" + coordenadaXorigen + "," + "Coordenadas destino: ("
                + coordenadaYorigen + ") " + coordenadaXdestino + "," + coordenadaYdestino 
                        + ") distancia: " + distancia +" tiempo: " + tiempo);
        
        return "Nombre Calle: " + nombre + " Coordenadas origen: (" + coordenadaXorigen + "," + "Coordenadas destino: ("
                + coordenadaYorigen + ") " + coordenadaXdestino + "," + coordenadaYdestino 
                        + ") distancia: " + distancia +" tiempo: " + tiempo + "\n";
        
        
    }

    public Calle() {
       setCoordenadaXorigen(0l);
       setCoordenadaYorigen(0l);
       setCoordenadaXdestino(0l);
       setCoordenadaYdestino(0l);
       setNombre("");
       setDistancia(0l);
       setTiempo(0l);
    }

    public Calle(Long coordenadaXorigen, Long coordenadaYorigen, Long coordenadaXdestino, Long coordenadaYdestino, String nombre, Long distancia, Long tiempo) {
        setCoordenadaXorigen(coordenadaXorigen);
        setCoordenadaYorigen(coordenadaYorigen);
        setCoordenadaXdestino(coordenadaXdestino);
        setCoordenadaYdestino(coordenadaYdestino);
        setNombre(nombre);
        setDistancia(distancia);
        setTiempo(tiempo);
    }

    
    

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Long getCoordenadaXorigen() {
        return coordenadaXorigen;
    }

    public void setCoordenadaXorigen(Long coordenadaXorigen) {
        this.coordenadaXorigen = coordenadaXorigen;
    }

    public Long getCoordenadaYorigen() {
        return coordenadaYorigen;
    }

    public void setCoordenadaYorigen(Long coordenadaYorigen) {
        this.coordenadaYorigen = coordenadaYorigen;
    }

    public Long getCoordenadaXdestino() {
        return coordenadaXdestino;
    }

    public void setCoordenadaXdestino(Long coordenadaXdestino) {
        this.coordenadaXdestino = coordenadaXdestino;
    }

    public Long getCoordenadaYdestino() {
        return coordenadaYdestino;
    }

    public void setCoordenadaYdestino(Long coordenadaYdestino) {
        this.coordenadaYdestino = coordenadaYdestino;
    }

    public Long getDistancia() {
        return distancia;
    }

    public void setDistancia(Long distancia) {
        this.distancia = distancia;
    }

    public Long getTiempo() {
        return tiempo;
    }

    public void setTiempo(Long tiempo) {
        this.tiempo = tiempo;
    }
    
    
    
}
