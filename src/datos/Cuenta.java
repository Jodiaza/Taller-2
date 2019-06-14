package datos;

public abstract class Cuenta {

    private int saldo;
    private String numeroDeCuenta;

    public int getSaldo() {
        return saldo;
    }

    public void setSaldo(int saldo) {
        this.saldo = saldo;
    }

    public String getNumeroDeCuenta() {
        return numeroDeCuenta;
    }

    public void setNumeroDeCuenta(String numeroDeCuenta) {
        this.numeroDeCuenta = numeroDeCuenta;
    }
}
