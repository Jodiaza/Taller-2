package datos;

public class Ahorro extends Cuenta {
    
    private static double retencion=0.0275; 
    private static double impuesto=3;
    
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
