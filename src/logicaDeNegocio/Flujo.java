package logicaDeNegocio;

import java.io.FileOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

import datos.Cliente;
import datos.Sistema;

public class Flujo implements Serializable{
	
	private static final long serialVersionUID = 8799656478674716698L;
	
public void crearObjeto(Cliente cliente) {
try {
 FileOutputStream salida = new FileOutputStream
        (cliente.getCuenta().getNumeroDeCuenta()+".obj");
	ObjectOutputStream objeto = new ObjectOutputStream(salida);
			objeto.writeObject(cliente);
			objeto.close();
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
		Path path = Paths.get(cliente.getCuenta().getNumeroDeCuenta()+".obj");
		Files.delete(path);
	}catch(Exception exception) {
		System.out.println();
	}
}
	
public void crearArray(Sistema sistema) {
	try {
	FileOutputStream salida = new FileOutputStream("ListaDeDocumentos.obj");
		ObjectOutputStream objeto = new ObjectOutputStream(salida);
		objeto.writeObject(sistema);
		objeto.close();
		}catch(Exception exception) {
			System.out.println("ERROR :(");
		}
		
	}
	
public ArrayList<String> leerArray() {
try {
	FileInputStream entrada = new FileInputStream("ListaDeDocumentos.obj");
        	ObjectInputStream objeto = new ObjectInputStream(entrada);
		ArrayList<String> lista = new ArrayList<String>();
		try {
                Sistema listaDocumentos= (Sistema) objeto.readObject();
                objeto.close();
                Set<String> set = listaDocumentos.getListaClientes().keySet();
		if(set.size()!=0) {
					for(String string:set) {
						lista.add(string);
					}
					return lista;
				}else {
					return null;
				}
			}catch(Exception exception) {
				return null;
			}
		}catch(Exception exception) {
			return null;
		}
	}
	
}
