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
public abstract class PagosPSE implements ComponentePagos{
    protected ComponentePagos componente;
    protected String banco;
     

    public PagosPSE(ComponentePagos componente) {
        this.componente = componente;
    }
    
    @Override
    public void ingresarDatos(String datos) throws Exception{
        this.banco = banco;
    }

    @Override
    public String mostrarDatos() {
        return componente.mostrarDatos() + "\n banco: " + banco;
    }
}
