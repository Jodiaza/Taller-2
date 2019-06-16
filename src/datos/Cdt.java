package datos;

import java.io.Serializable;

public class Cdt extends Cuenta implements Serializable{
    
    private static double interes=0.045;
    private static final long serialVersionUID = 8799656478674716668L;
    

    public static double getInteres() {
		return interes;
	}


	public static void setInteres(double interes) {
		Cdt.interes = interes;
	}


	public Cdt(double saldo, String numeroDeCuenta) {
        setSaldo(saldo);
        setNumeroDeCuenta(numeroDeCuenta);
    }

    
}
