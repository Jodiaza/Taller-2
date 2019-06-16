package datos;

import datos.Cuenta;
import datos.EntidadFinanciera;
import datos.Ahorro;
import datos.Sistema;
import java.io.Serializable;
import java.math.BigDecimal;

public class Cliente implements EntidadFinanciera, Serializable{
    
    private String nombre;
    private String documento;
    private String clave;
    private Cuenta cuenta; 
    private static final long serialVersionUID = 8799656478674716639L;
    
    public Cliente(String nombre, String documento, String clave, Cuenta cuenta)
    {
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
    	double consignacion=valor+(getCuenta().getSaldo())*(1-Ahorro.getRetencion());
        getCuenta().setSaldo(consignacion);
        System.out.println("La consignacion ha sido exitosa.\nSu saldo actual es: "
        		+ ""+BigDecimal.valueOf(getCuenta().getSaldo()).toPlainString()+"$");
        
    }

    public void retirar(double valor) {
    	if(valor<getCuenta().getSaldo()-5000) {
    		double retiro=(getCuenta().getSaldo())*(1-Ahorro.getRetencion())-valor;
	        retiro =retiro-(valor-valor*Ahorro.getCobroRetiro());
	        getCuenta().setSaldo(retiro);
	        System.out.println("El retiro ha sido exitoso.\nSu  saldo  alcual es: "
	        		+ ""+BigDecimal.valueOf(getCuenta().getSaldo()).toPlainString()+"$");
    	}else {
    		System.out.println("Debe dejar en la cuenta al menos 5000$. Vuelva a intentar");
    		Sistema sistema = new Sistema();
    		retirar(sistema.introducirDinero());
    	}
    }

	@Override
	public String toString() {
            String string="";
            string=string.concat("-Nombre: "+getNombre()+"\n-Documento: "
                +getDocumento()+"\n-Numero de "
                + "cuenta: "+getCuenta().getNumeroDeCuenta()
                +"\n-Saldo: "+BigDecimal.valueOf(getCuenta().getSaldo()).toPlainString()+"$");
		return string;
	}
    
    

    
    
}
