package datos;

public class Cliente {
    
    private String nombre;
    private Long documento;
    private int clave;
    private int saldo;
    private int numeroDeCuenta;
    private CuentaBancaria tipoDeCuenta;
    private int tasaDeInteresPrestamo;
    
    public Cliente(String nombre, Long documento, int clave, int saldo, int numeroDeCuenta) {
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

    public Long getDocumento() {
        return documento;
    }
    
    public int getNumeroDeCuenta(){
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

    public void setDocumento(Long documento) {
        this.documento = documento;
    }
    
    public void setNumeroDeCuenta(int numeroDeCuenta){
        this.numeroDeCuenta = numeroDeCuenta;
    }  
    
}
