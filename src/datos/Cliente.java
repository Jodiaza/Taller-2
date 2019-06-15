package datos;

import datos.Cuenta;
import datos.EntidadFinanciera;
import datos.Ahorro;

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
        double consignacion=valor+(getCuenta().getSaldo())*(1-Ahorro.getRetencion());
        getCuenta().setSaldo(consignacion);
        System.out.println("La consignaci�n ha sido exitosa");
    }

    public void retirar(double valor) {
        double retiro=(getCuenta().getSaldo())*(1-Ahorro.getRetencion())-valor;
        getCuenta().setSaldo(retiro);
        System.out.println("El retiro ha sido exitoso");
    }

    public double consultarSaldo() {
        return getCuenta().getSaldo();
    }

	@Override
	public String toString() {
		String string="";
		string=string.concat("-Nombre: "+getNombre()+"\n-Documento: "+getDocumento()+"\n-N�mero de "
				+ "cuenta: "+getCuenta().getNumeroDeCuenta()+"\n-Saldo: "+getCuenta().getSaldo()+"$");
		return string;
	}
    
    

    
    
}
