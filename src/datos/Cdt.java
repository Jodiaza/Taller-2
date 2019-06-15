package datos;

public class Cdt extends Cuenta{
    
    private static double interes=2.3;

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
