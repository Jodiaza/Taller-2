package datos;
import java.util.*;

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
        System.out.println("Introduzca el saldo del cliente:");
        int saldo = sc.nextInt();
        System.out.println("Introduzca el número de cuenta del cliente:");
        long numeroDeCuenta = sc.nextLong();
        //Agregar tipo de cuenta
        Cliente nuevoCliente = new Cliente(nombre, documento, clave, saldo, numeroDeCuenta);
        listaClientes.put(documento, nuevoCliente);
    }
    
    public void consultarCliente(String documento, HashMap<String, Cliente> listaClientes) {
       if(listaClientes.containsKey(documento)) {
           Cliente clienteConsultado = listaClientes.get(documento);
           System.out.println("Nombre:" + clienteConsultado.getNombre());
           System.out.println("Documento:" + clienteConsultado.getDocumento());
           System.out.println("Número de cuenta:" + clienteConsultado.getNumeroDeCuenta());
           System.out.println("Saldo:" + clienteConsultado.getSaldo());
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
            clienteModificado.setNumeroDeCuenta(sc.nextLong());
            //Modificar tipo de cuenta
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
