package datos;
import java.util.*;
import datos.Cuenta;
import logicaDeNegocio.Taller2;

public class Sistema {
    
    private static HashMap<String, Cliente> listaClientes = new HashMap<String, Cliente>();
    
    public static HashMap<String, Cliente> getListaClientes() {
		return listaClientes;
	}

	public static void setListaClientes(HashMap<String, Cliente> listaClientes) {
		Sistema.listaClientes = listaClientes;
	}

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
    
    public void crearCliente() {
    	Cliente cliente=new Cliente(introducirCliente(), introducirDocumento(), introducirClave(), introducirCuenta());
        listaClientes.put(cliente.getDocumento(), cliente);
        System.out.println("La cuenta se ha creado con éxito");
    }
    
    public String introducirCliente(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduzca el nombre del cliente:");
        String nombre = sc.nextLine();
        if(nombre.length()!=0) {
        	return nombre;
        }else {
        	System.out.println("Nombre vacío. Vuelva a intentar.");
        	return introducirCliente();
        }
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
        System.out.println("Introduzca la clave del cliente(4 caracteres):");
        String clave = sc.nextLine();
        if(clave.length()==4){
            return clave;
        }else{
        	System.out.println("Introdujo una contraseña inválida. Esta debe tener 4 números"
        			+ " únicamente. Vuelva a intentar.");
            return introducirClave();
        }
    }
    
    public String introducirNumeroDeCuenta() {
    	Scanner sc = new Scanner(System.in);
        System.out.println("Introduzca el número de cuenta del cliente:");
        String numeroCuenta = sc.nextLine();
        if(numeroCuenta.length()==7){
            return numeroCuenta;
        }else{
        	System.out.println("Introdujo un número de cuenta inválido. Este debe tener 7 números."
        			+ " Vuelva a intentar.");
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
        	System.out.println("Introdujo un caracter equivocado. Recuerde ingresar solo enteros."
        			+ " Vuelva a intentar.");
            return introducirSaldo();
        }
    }
    
    public Cuenta introducirCuenta(){
    	Scanner sc = new Scanner(System.in);
    	System.out.println("Seleccione el tipo de cuenta que desea crear:\n1. Cuenta de ahorros."
    			+ "\n2. Certificado a termino fijo.\n3. Volver.\n");
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
		case "3":
			Taller2.bienvenida();

		default:
			System.out.println("Introdujo un comando equivocado. Vuelva a intentar.");
			return introducirCuenta();
		}
        
    }
   
    public void consultarCliente() {
    	String documento = introducirDocumento();
    	if(listaClientes.containsKey(documento)) {
    		String clave = introducirClave();
    		if(listaClientes.get(documento).getClave().equals(clave)){
    			Cliente clienteConsultado = listaClientes.get(documento);
    			System.out.println("Nombre:" + clienteConsultado.getNombre());
    			System.out.println("Documento:" + clienteConsultado.getDocumento());
    			System.out.println("Número de cuenta:" + clienteConsultado.getCuenta().getNumeroDeCuenta());
    			System.out.println("Saldo:" + clienteConsultado.getCuenta().getSaldo());
    		}else {
    			System.out.println("Contraseña incorrecta.");
    			Taller2.bienvenida();
    		}
        } else {
           System.out.println("No hay ningun cliente con ese documento.");  
           Taller2.bienvenida();
        }
    }
    
    public void modificarCliente() {
        String documento=introducirDocumento();
        if(listaClientes.containsKey(documento)) {
        	String clave = introducirClave();
        	if(listaClientes.get(documento).getClave().equals(clave)) {
	            Cliente clienteModificado = listaClientes.get(documento);
	            clienteModificado.setNombre(introducirCliente());
	            System.out.println("El nombre se ha cambiado con éxito");
        	}else {
        		System.out.println("Contraseña incorrecta.");
    			Taller2.bienvenida();
        	}
        } else {
            System.out.println("No hay ningun cliente con ese documento.");  
            Taller2.bienvenida();
        }
        
    }
    
    public void eliminarCliente() {
        String documento=introducirDocumento();
    	if(listaClientes.containsKey(documento)) {
    		String clave = introducirClave();
            if(listaClientes.get(documento).getClave().equals(clave)) {
	    		listaClientes.remove(documento);
	            System.out.println("La cuenta se ha eliminado con éxito");
            }else {
            	System.out.println("Contraseña incorrecta.");
    			Taller2.bienvenida();
            }
        } else {
            System.out.println("No hay ningun cliente con ese documento.");  
            Taller2.bienvenida();
        }
    }
    
    public void anadirImpuesto(Cliente cliente) {
    	double saldo = cliente.getCuenta().getSaldo();
    	if(cliente.getCuenta().getClass()==Ahorro.class) {
    		cliente.getCuenta().setSaldo(saldo+saldo*Ahorro.getImpuesto());
    	}else if(cliente.getCuenta().getClass()==Cdt.class) {
    		cliente.getCuenta().setSaldo(saldo+saldo*Cdt.getInteres());
    	}
    }
    
    public void anadirImpuestoATodo() {
    	for (Map.Entry<String, Cliente> entry : listaClientes.entrySet()) {
    	    anadirImpuesto(entry.getValue());
    	}
    }
    
    public void imprimirPlatudos() {
    	ArrayList<Cliente> top=new ArrayList<>();
    	for (Map.Entry<String, Cliente> entry : listaClientes.entrySet()) {
    	    top.add(entry.getValue());
    	}
    	Collections.sort(top, new Comparator<Cliente>(){
    		 
            @Override
            public int compare(Cliente cliente1, Cliente cliente2) {
               double valor = cliente1.getCuenta().getSaldo()-cliente2.getCuenta().getSaldo();
               int casteo = (int) valor;
               return casteo;
            }
        });
    	for(int i=1;i<=5;i++) {
    		System.out.println(i+".\n"+top.get(i-1)+"\n");
    	}
    }

}
