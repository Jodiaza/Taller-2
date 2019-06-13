package datos;

public interface EntidadFinanciera{
    
    public void consignar(int valor);   
    
    public void retirar(int valor);
    
    public int consultarSaldo();
    
}
