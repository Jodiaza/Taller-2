package logicaDeNegocio;

import java.io.FileOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

import datos.Cliente;

public class Flujo implements Serializable{
	
	public void crearObjeto(Cliente cliente) {
		try {
			FileOutputStream salida = new FileOutputStream(cliente.getDocumento()+".obj");
			ObjectOutputStream objeto = new ObjectOutputStream(salida);
			objeto.writeObject(cliente);
			objeto.close();
			salida.close();
		}catch(Exception exception) {
			System.out.println("ERROR :(");
		}
		
	}
	
	public Cliente leerObjeto(String file) {
		try {
			FileInputStream entrada = new FileInputStream(file);
			ObjectInputStream objeto = new ObjectInputStream(entrada);
			try {
				Cliente cliente = (Cliente) objeto.readObject();
				objeto.close();
				entrada.close();
				return cliente;
			}catch(Exception exception) {
				System.out.println(exception);
				return null;
			}
		}catch(Exception exception) {
			System.out.println(exception);
			return null;
		}
	}
	
	public void eliminarObjeto(Cliente cliente) {
		try {
			File file = new File(cliente.getDocumento()+".obj");
			file.delete();
		}catch(Exception exception) {
			System.out.println("ERROR :(");
		}
	}
	
	public void crearArray(HashMap<String,Cliente> lista) {
		try {
			FileOutputStream salida = new FileOutputStream("ListaDeDocumentos.obj");
			ObjectOutputStream objeto = new ObjectOutputStream(salida);
			ArrayList<String> listaDocumentos =new ArrayList<String>();
			Set set = lista.keySet();
			for(Object documento:set) {
				String doc = (String)documento;
				listaDocumentos.add(doc);
			}
			objeto.writeObject(listaDocumentos);
			objeto.close();
			salida.close();
		}catch(Exception exception) {
			System.out.println("ERROR :(");
		}
		
	}
	
	public ArrayList<String> leerArray() {
		try {
			FileInputStream entrada = new FileInputStream("ListaDeDocumentos.obj");
			ObjectInputStream objeto = new ObjectInputStream(entrada);
			try {
				ArrayList<String> listaDocumentos= (ArrayList<String>) objeto.readObject();
				objeto.close();
				entrada.close();
				return listaDocumentos;
			}catch(Exception exception) {
				return null;
			}
		}catch(Exception exception) {
			return null;
		}
	}
	
}
