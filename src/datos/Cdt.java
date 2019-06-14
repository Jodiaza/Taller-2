package datos;

public class Cdt extends Cuenta{
    
    private static int interes;

    public static int getInteres() {
        return interes;
    }

    public static void setInteres(int interes) {
        Cdt.interes = interes;
    }

    public Cdt(int saldo, String numeroDeCuenta, int interes) {
        super();
        setSaldo(saldo);
        setNumeroDeCuenta(numeroDeCuenta);
        setInteres(interes);
    }

    
}
