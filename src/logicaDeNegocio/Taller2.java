package logicaDeNegocio;

import java.util.Scanner;
import datos.Sistema;

public class Taller2 {
	private static Sistema sistema = new Sistema();
	
    public static Sistema getSistema() {
		return sistema;
	}

	public static void setSistema(Sistema sistema) {
		Taller2.sistema = sistema;
	}

	public static void main(String[] args) {
        //extraer de flujo y agregar al hashmap "listaClientes" de sistema.
        sistema.anadirImpuestoATodo();
        bienvenida();
        
    }
    
    public static void bienvenida() {
    	Scanner sc = new Scanner(System.in);
    	System.out.println("Bienvenido al banco Javaliste!\nPorfavor  escoja una de las"
    			+ " siguientes opciones:\n1. Crear una cuenta.\n2. Eliminar una cuenta.\n"
    			+ "3. Modificar el nombre del usuario de una  cuenta.\n4. Consultar "
    			+ "la información de una cuenta.\n5. Ver el ranquing de malditos burgueses.");
    	String entrada= sc.nextLine();
    	switch (entrada) {
		case "1":
			sistema.crearCliente();
			break;
		case "2":
			sistema.eliminarCliente();
			break;
		case "3":
			sistema.modificarCliente();
			break;
		case "4":
			sistema.consultarCliente();
			break;
		case "5":
			sistema.imprimirPlatudos();
			break;
		default:
			System.out.println("Introdujo un comando equivocado. Vuelva a intentar.");
			bienvenida();
		}
    }
}
