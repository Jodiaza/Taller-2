package datos;

public class Cliente implements EntidadFinanciera{
    
    private String nombre;
    private String documento;
    private int clave;
    private Cuenta cuenta; 
    
    public Cliente(String nombre, String documento, int clave, Cuenta cuenta) {
        this.nombre = nombre;
        this.documento = documento;
        this.clave = clave;
        this.cuenta = cuenta;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public int getClave() {
        return clave;
    }

    public void setClave(int clave) {
        this.clave = clave;
    }

    public Cuenta getCuenta() {
        return cuenta;
    }

    public void setCuenta(Cuenta cuenta) {
        this.cuenta = cuenta;
    }

    @Override
    public void consignar(int valor) {
        int consignacion=valor+getCuenta().getSaldo();
        getCuenta().setSaldo(consignacion);
    }

    @Override
    public void retirar(int valor) {
        int retiro=getCuenta().getSaldo()-valor;
        getCuenta().setSaldo(retiro);
    }

    @Override
    public int consultarSaldo() {
        return getCuenta().getSaldo();
    }
    
    

    
    
}
