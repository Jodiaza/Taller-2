package datos;

public class Ahorro extends Cuenta {
    
    public final double cobroRetiro=2.7; 

    public Ahorro(double saldo, String numeroDeCuenta) {
        setSaldo(saldo);
        setNumeroDeCuenta(numeroDeCuenta);
    }
    
    
    
}
