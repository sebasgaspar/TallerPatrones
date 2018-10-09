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
public class PagosPSECredito extends PagosPSE{
    private String tarjeta;
    private String seguridad;
    private int cuotas = 0;
    

    public PagosPSECredito(ComponentePagos componente) {
        super(componente);
    }
    
    @Override
    public void ingresarDatos(String datos) throws Exception{
        String[] dato = datos.split(",");
        tarjeta = dato[0];
        seguridad = dato[1]; 
        cuotas = Integer.parseInt(dato[2]);
        super.ingresarDatos(dato[3]);
        
    }

    @Override
    public String mostrarDatos() {
        return super.mostrarDatos() + "\ntarjeta : " + tarjeta + "\ncuotas: " + cuotas + "\nseguridad: " + seguridad;
    }
    
    

    public int getCuotas() {
        return cuotas;
    }

    public void setCuotas(int cuotas) {
        this.cuotas = cuotas;
    }
    
    

    public String getTarjeta() {
        return tarjeta;
    }

    public void setTarjeta(String tarjeta) {
        this.tarjeta = tarjeta;
    }

    public String getSeguridad() {
        return seguridad;
    }

    public void setSeguridad(String seguridad) {
        this.seguridad = seguridad;
    }
    
    
}
