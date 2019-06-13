package datos;

public class Ahorro extends Cuenta {
    
    private static int cobroRetiro=3000; 

    public static int getCobroRetiro() {
        return cobroRetiro;
    }

    public static void setCobroRetiro(int cobroRetiro) {
        Ahorro.cobroRetiro = cobroRetiro;
    }

    public Ahorro(int saldo, String numeroDeCuenta, String tipoDeCuenta) {
        setSaldo(saldo);
        setNumeroDeCuenta(numeroDeCuenta);
        setTipoDeCuenta(tipoDeCuenta);
    }
    
    
    
}
