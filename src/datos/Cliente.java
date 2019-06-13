package datos;

public class Cliente {
    
    private String nombre;
    private String documento;
    private int clave;
    private int saldo;
    private long numeroDeCuenta;
    private CuentaBancaria tipoDeCuenta;
    
    public Cliente(String nombre, String documento, int clave, int saldo, long numeroDeCuenta) {
        this.nombre = nombre;
        this.documento = documento;
        this.clave = clave;
        this.saldo = saldo;
        this.numeroDeCuenta = numeroDeCuenta;
    }

    public String getNombre() {
        return nombre;
    }

    public int getClave() {
        return clave;
    }

    public int getSaldo() {
        return saldo;
    }

    public String getDocumento() {
        return documento;
    }
    
    public long getNumeroDeCuenta(){
        return numeroDeCuenta;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setClave(int clave) {
        this.clave = clave;
    }

    public void setSaldo(int saldo) {
        this.saldo = saldo;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }
    
    public void setNumeroDeCuenta(long numeroDeCuenta){
        this.numeroDeCuenta = numeroDeCuenta;
    }  
    
}
