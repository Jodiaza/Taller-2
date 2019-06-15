package datos;
import java.util.*;
import datos.Cuenta;

public class Sistema {
    
    HashMap<String, Cliente> listaClientes = new HashMap<String, Cliente>();
    
    public boolean esNumero(String string) {
        boolean resultado;
        try {
            Integer.parseInt(string);
            resultado = true;
        } catch (NumberFormatException excepcion) {
            resultado = false;
        }
        return resultado;
    }
    
    public void crearCliente(HashMap<String, Cliente> listaClientes) {
    	Cliente cliente=new Cliente(introducirCliente(), introducirDocumento(), introducirClave(), introducirCuenta());
        listaClientes.put(cliente.getDocumento(), cliente);
        System.out.println("La cuenta se ha creado con éxito");
    }
    
    public String introducirCliente(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduzca el nombre del cliente:");
        String nombre = sc.nextLine();
        return nombre;
    }
    
    public String introducirDocumento(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduzca el documento del cliente:");
        String documento = sc.nextLine();
        if(documento.length()>=7&&documento.length()<=10){
            return documento;
        }else{
        	System.out.println("Introdujo un comando equivocado. Vuelva a intentar.");
            return introducirDocumento();
        }
    }
    
    public String introducirClave(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduzca la clave del cliente:");
        String clave = sc.nextLine();
        if(clave.length()==4){
            return clave;
        }else{
        	System.out.println("Introdujo un comando equivocado. Vuelva a intentar.");
            return introducirClave();
        }
    }
    
    public String introducirNumeroDeCuenta() {
    	Scanner sc = new Scanner(System.in);
        System.out.println("Introduzca el número de cuenta del cliente:");
        String numeroCuenta = sc.nextLine();
        if(numeroCuenta.length()==4){
            return numeroCuenta;
        }else{
        	System.out.println("Introdujo un comando equivocado. Vuelva a intentar.");
            return introducirNumeroDeCuenta();
        }
    }
    
    public double introducirSaldo() {
    	Scanner sc = new Scanner(System.in);
        System.out.println("Introduzca el saldo del cliente:");
        String saldo = sc.nextLine();
        if(esNumero(saldo)){
            return (double)Integer.parseInt(saldo);
        }else{
        	System.out.println("Introdujo un comando equivocado. Vuelva a intentar.");
            return introducirSaldo();
        }
    }
    
    public Cuenta introducirCuenta(){
    	Scanner sc = new Scanner(System.in);
    	System.out.println("Seleccione el tipo de cuenta que desea crear:\n1. Cuenta de ahorros."
    			+ "\n2. Certificado a termino fijo (solo hay disponibles cdt a 30 días con interés del 2.3%).");
    	switch (sc.nextLine()) {
		case "1":
			String numeroDeCuentaA=introducirNumeroDeCuenta();
	        double saldoA=introducirSaldo();
	        Ahorro ahorro = new Ahorro(saldoA, numeroDeCuentaA);
	        return ahorro;
		case "2":
			String numeroDeCuentaC=introducirNumeroDeCuenta();
	        double saldoC=introducirSaldo();
	        Cdt cdt = new Cdt(saldoC, numeroDeCuentaC);
			return cdt;

		default:
			System.out.println("Introdujo un comando equivocado. Vuelva a intentar.");
			return introducirCuenta();
		}
        
    }
   
    public void consultarCliente(HashMap<String, Cliente> listaClientes) {
    	String documento = introducirDocumento();
    	if(listaClientes.containsKey(documento)) {
           Cliente clienteConsultado = listaClientes.get(documento);
           System.out.println("Nombre:" + clienteConsultado.getNombre());
           System.out.println("Documento:" + clienteConsultado.getDocumento());
           System.out.println("Número de cuenta:" + clienteConsultado.getCuenta().getNumeroDeCuenta());
           System.out.println("Saldo:" + clienteConsultado.getCuenta().getSaldo());
        } else {
           System.out.println("No hay ningun cliente con ese documento.");  
           
        }
    }
    
    public void modificarCliente(HashMap<String, Cliente> listaClientes) {
        String documento=introducirDocumento();
        if(listaClientes.containsKey(documento)) {
            Cliente clienteModificado = listaClientes.get(documento);
            clienteModificado.setNombre(introducirCliente());
            System.out.println("El nombre se ha cambbiado con éxito");
        } else {
            System.out.println("No hay ningun cliente con ese documento.");  
            
        }
        
    }
    
    public void eliminarCLiente(HashMap<String, Cliente> listaClientes) {
        String documento=introducirDocumento();
    	if(listaClientes.containsKey(documento)) {
            listaClientes.remove(documento);
            System.out.println("La cuenta se ha eliminado con éxito");
        } else {
            System.out.println("No hay ningun cliente con ese documento.");  
        }
    }
    

}
