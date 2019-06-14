package datos;

public class Ahorro extends Cuenta {
    
    public final int cobroRetiro=3000; 

    public Ahorro(int saldo, String numeroDeCuenta) {
        setSaldo(saldo);
        setNumeroDeCuenta(numeroDeCuenta);
    }
    
    
    
}
