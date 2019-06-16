package logicaDeNegocio;

import java.util.ArrayList;
import java.util.Scanner;
import datos.Sistema;

public class Taller2 {
	private static Sistema sistema = new Sistema();
	private static Flujo flujo = new Flujo();

	public static void main(String[] args) {
		System.out.println(flujo.leerObjeto("1234567.obj").toString());
		//inicializarLista();
		//sistema.anadirImpuestoATodo();
        //bienvenida();
        
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
			flujo.crearArray(Sistema.getListaClientes());
			break;
		case "2":
			sistema.eliminarCliente();
			flujo.crearArray(Sistema.getListaClientes());
			break;
		case "3":
			sistema.modificarCliente();
			flujo.crearArray(Sistema.getListaClientes());
			break;
		case "4":
			sistema.consultarCliente();
			flujo.crearArray(Sistema.getListaClientes());
			break;
		case "5":
			sistema.imprimirPlatudos();
			flujo.crearArray(Sistema.getListaClientes());
			break;
		default:
			System.out.println("Introdujo un comando equivocado. Vuelva a intentar.");
			bienvenida();
		}
    }
    
    public static void inicializarLista() {
    	if(flujo.leerArray().size()==0) {
    		ArrayList<String> documentos = flujo.leerArray();
	    	for(String documento:documentos) {
	    		Sistema.getListaClientes().put(documento, flujo.leerObjeto(documento+".obj"));
	    	}
    	}else {}
    }
}
