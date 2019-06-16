package datos;

import java.io.Serializable;

public abstract class Cuenta implements Serializable{

    private double saldo;
    private String numeroDeCuenta;
    private static final long serialVersionUID = 8799656478674716658L;

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public String getNumeroDeCuenta() {
        return numeroDeCuenta;
    }

    public void setNumeroDeCuenta(String numeroDeCuenta) {
        this.numeroDeCuenta = numeroDeCuenta;
    }
}
