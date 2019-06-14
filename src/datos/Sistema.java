package datos;
import java.util.*;
import datos.Cuenta;

public class Sistema {
    
    HashMap<String, Cliente> listaClientes = new HashMap<String, Cliente>();
    
    public void crearCliente(HashMap<String, Cliente> listaClientes) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduzca el nombre del cliente:");
        String nombre = sc.nextLine();
        System.out.println("Introduzca el documento del cliente:");
        String documento = sc.nextLine();
        System.out.println("Introduzca la clave del cliente:");
        int clave = sc.nextInt();
        System.out.println("Introduzca el número de cuenta del cliente:");
        String num_cuenta = sc.next();
        Cuenta cuenta = new Cdt(0, num_cuenta,3);
        //Agregar tipo de cuenta
        Cliente nuevoCliente = new Cliente(nombre, documento, clave, cuenta);
        listaClientes.put(documento, nuevoCliente);
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
            return introducirClave();
        }
    }
    
    /*public Cuenta introducirCuenta(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduzca la clave del cliente:");
    }*/
    
    public void consultarCliente(String documento, HashMap<String, Cliente> listaClientes) {
       if(listaClientes.containsKey(documento)) {
           Cliente clienteConsultado = listaClientes.get(documento);
           System.out.println("Nombre:" + clienteConsultado.getNombre());
           System.out.println("Documento:" + clienteConsultado.getDocumento());
           System.out.println("Número de cuenta:" + clienteConsultado.getCuenta().getNumeroDeCuenta());
           System.out.println("Saldo:" + clienteConsultado.getCuenta().getSaldo());
           //Consultar tipo de cuenta
        } else {
            System.out.println("No hay ningun cliente con ese documento.");  
        }
    }
    
    public void modificarCliente(String documento, HashMap<String, Cliente> listaClientes) {
        Scanner sc = new Scanner(System.in);
        if(listaClientes.containsKey(documento)) {
            Cliente clienteModificado = listaClientes.get(documento);
            System.out.println("Introduzca el nombre del cliente:");
            clienteModificado.setNombre(sc.nextLine());
            //System.out.println("Introduce el documento del cliente:");
            //clienteModificado.setDocumento(sc.nextLine()); 
            //Como el documento es la llave del hashmap ahi que modificarlo diferente.
            System.out.println("Introduzca la clave del cliente:");
            clienteModificado.setClave(sc.nextInt());
            System.out.println("Introduzca el número de cuenta del cliente:");
            clienteModificado.getCuenta().setNumeroDeCuenta(sc.next());
            //Modificar tipo de cuenta
            
            /*Esto lo usa ara mod saldo
            clienteModificado.getCuenta().setSaldo(nuevo valor);*/
        } else {
            System.out.println("No hay ningun cliente con ese documento.");  
            
        }
        
    }
    
    public void eliminarCLiente(String documento, HashMap<String, Cliente> listaClientes) {
        if(listaClientes.containsKey(documento)) {
            listaClientes.remove(documento);
        } else {
            System.out.println("No hay ningun cliente con ese documento.");  
        }
    }
    
    //Pendiente
    public void modificarSaldo() {
        
    }
}
