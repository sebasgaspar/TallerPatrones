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
public class Pagos implements ComponentePagos{
    private long valor;
    private String conductor;
    private String pasajero;
    
    

    @Override
    public void ingresarDatos(String datos) throws Exception{
        String[] dato = datos.split(",");
        conductor = dato[0];
        pasajero = dato[1];
        long valor = Long.parseLong(dato[2]);
        
        if(valor>0){
            setValor(valor);
        }else{
            throw new Exception("pago invalido");
        }
    }

    @Override
    public String mostrarDatos() {
        return "valor : " + valor + "\n conductor pagado: " + conductor + "\n pasajero que pagó:  " + pasajero;
    }

    public Pagos() {
    }


    
    
    
    public long getValor() {
        return valor;
    }

    public void setValor(long valor) {
        this.valor = valor;
    }

    public String getConductor() {
        return conductor;
    }

    public void setConductor(String conductor) {
        this.conductor = conductor;
    }

    public String getPasajero() {
        return pasajero;
    }

    public void setPasajero(String pasajero) {
        this.pasajero = pasajero;
    }

    
    
    
}
