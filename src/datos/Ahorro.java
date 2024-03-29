package datos;

import java.io.Serializable;

public class Ahorro extends Cuenta implements Serializable{
    
    private static double retencion=0.0275; 
    private static double impuesto=0.03;
    private static double cobroRetiro=0.05;
    private static final long serialVersionUID = 8799656478674716648L;
    
    public static double getCobroRetiro() {
		return cobroRetiro;
	}

	public static void setCobroRetiro(double cobroRetiro) {
		Ahorro.cobroRetiro = cobroRetiro;
	}

	public static double getRetencion() {
		return retencion;
	}

	public static void setRetencion(double retencion) {
		Ahorro.retencion = retencion;
	}

	public static double getImpuesto() {
		return impuesto;
	}

	public static void setImpuesto(double impuesto) {
		Ahorro.impuesto = impuesto;
	}

	public Ahorro(double saldo, String numeroDeCuenta) {
        setSaldo(saldo);
        setNumeroDeCuenta(numeroDeCuenta);
    }
        
}
