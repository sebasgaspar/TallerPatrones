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
public class PagosPSECuenta extends PagosPSE{
    private String numerodecuenta;
    private String tipoCuenta;
    
    @Override
    public void ingresarDatos(String datos) throws Exception{
        String[] dato = datos.split(",");
        tipoCuenta = dato[0];
        numerodecuenta = dato[1];
        super.ingresarDatos(dato[2]);
        
    }

    @Override
    public String mostrarDatos() {
        return super.mostrarDatos() + "banco: " + banco + "cuenta: " + numerodecuenta;
    }
    
    public PagosPSECuenta(ComponentePagos componente) {
        super(componente);
    }
    
    
    public String getNumerodecuenta() {
        return numerodecuenta;
    }

    public void setNumerodecuenta(String numerodecuenta) {
        this.numerodecuenta = numerodecuenta;
    }

    public String getTipoCuenta() {
        return tipoCuenta;
    }

    public void setTipoCuenta(String tipoCuenta) {
        this.tipoCuenta = tipoCuenta;
    }
    
    
    
    
}
