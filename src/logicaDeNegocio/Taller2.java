package logicaDeNegocio;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;

import datos.Ahorro;
import datos.Cliente;
import datos.Sistema;

public class Taller2 implements Serializable{
	private static Sistema sistema = new Sistema();
	private static Flujo flujo = new Flujo();
	private static final long serialVersionUID = 8799656478674716688L;

	public static void main(String[] args) {
		inicializarLista();
		sistema.anadirImpuestoATodo();
        bienvenida();
        
    }
	
    public static void bienvenida() {
    	Scanner sc = new Scanner(System.in);
    	System.out.println("Bienvenido al banco Javaliste!\nPorfavor  escoja "
                + "una de las siguientes opciones:\n1. Crear una cuenta.\n2. "
                + "Eliminar una cuenta.\n3. Modificar el nombre del usuario "
                + "de una cuenta.\n4. Consultar la informacion de una cuenta."
                + "\n5. Retirar dinero.\n6. Consignar dinero.\n7. Ver el "
                + "ranquing clientes.");
    	String entrada= sc.nextLine();
    	switch (entrada) {
		case "1":
			sistema.crearCliente();
			flujo.crearArray(sistema);
			break;
		case "2":
			sistema.eliminarCliente();
			flujo.crearArray(sistema);
			break;
		case "3":
			sistema.modificarCliente();
			flujo.crearArray(sistema);
			break;
		case "4":
			sistema.consultarCliente();
			flujo.crearArray(sistema);
			break;
		case "5":
			retirarDinero();
			break;
		case "6":
			consignarDinero();
			break;
		case "7":
			sistema.imprimirPlatudos();
			flujo.crearArray(sistema);
			break;
		default:
			System.out.println("Introdujo un comando equivocado. "
                                + "Vuelva a intentar.");
			bienvenida();
		}
    }
    
    public static void inicializarLista() {
	   if(flujo.leerArray()!=null) { 	
	    	if(flujo.leerArray().size()!=0) {
	    		ArrayList<String> cuentas = flujo.leerArray();
		    	for(String cuenta:cuentas) {
		    		sistema.getListaClientes().put(cuenta, 
                                        flujo.leerObjeto(cuenta+".obj"));
		    	}
	    	}else {}
	   }else {}
    }
    
    public static void consignarDinero() {
    	String cuenta = sistema.introducirNumeroDeCuenta();	
            if(sistema.getListaClientes().containsKey(cuenta)) {
		Cliente cliente = sistema.getListaClientes().get(cuenta);
		String clave = sistema.introducirClave();
		if(clave.equals(cliente.getClave())){
                    if(cliente.getCuenta().getClass().equals(Ahorro.class)) {
			cliente.consignar(sistema.introducirDinero());
                    }else {
		System.out.println("Su cuenta bancaria es de tipo cdt. Usted no"
				+ "puede consignar dinero en esta cuenta.");
					Taller2.bienvenida();
                            }
                    }else {
		System.out.println("Contrasena incorrecta.");
    			Taller2.bienvenida();
			}
		}else {
                System.out.println("No hay ningun cliente con ese documento.");  
                        Taller2.bienvenida();
		}
		
    }
    
    public static void retirarDinero() {
    	String cuenta = sistema.introducirNumeroDeCuenta();	
        	if(sistema.getListaClientes().containsKey(cuenta)) {
                Cliente cliente = sistema.getListaClientes().get(cuenta);
               	String clave = sistema.introducirClave();
		if(clave.equals(cliente.getClave())){
		if(cliente.getCuenta().getClass().equals(Ahorro.class)) {
        		cliente.retirar(sistema.introducirDinero());
		}else {
			if(cliente.getCuenta().getSaldo()>10000000) {
         		    cliente.retirar(sistema.introducirDinero());
				}else{
					System.out.println("Su cuenta bancaria "
                                            + "es de tipo cdt. Hasta no tener"
                                            + " mas de 10000000$ en su cuenta "
                                            + "no podra retirarlos");
						Taller2.bienvenida();
					}
				}
			}else {
				System.out.println("Contrasena incorrecta.");
    			Taller2.bienvenida();
			}
            }else {
                System.out.println("No hay ningun cliente con ese documento.");  
	        Taller2.bienvenida();
		}
		
    }
}
