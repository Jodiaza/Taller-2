package datos;

import datos.Cuenta;
import datos.EntidadFinanciera;

public class Cliente implements EntidadFinanciera{
    
    private String nombre;
    private String documento;
    private String clave;
    private Cuenta cuenta; 
    
    public Cliente(String nombre, String documento, String clave, Cuenta cuenta) {
        this.nombre = nombre;
        this.documento = documento;
        this.clave = clave;
        this.cuenta = cuenta;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public Cuenta getCuenta() {
        return cuenta;
    }

    public void setCuenta(Cuenta cuenta) {
        this.cuenta = cuenta;
    }

    public void consignar(double valor) {
        double consignacion=valor+getCuenta().getSaldo();
        getCuenta().setSaldo(consignacion);
    }

    public void retirar(double valor) {
        double retiro=getCuenta().getSaldo()-valor;
        getCuenta().setSaldo(retiro);
    }

    public double consultarSaldo() {
        return getCuenta().getSaldo();
    }
    
    

    
    
}
