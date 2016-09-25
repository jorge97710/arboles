import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import javax.swing.JOptionPane;


public class Diccionario {
	// Atributos
	private ArbolBinario<Asociacion<String,String>> arbol = new ArbolBinario<Asociacion<String,String>>(); 
	private Asociacion<String,String> cole = new Asociacion<String,String>();
	private ArrayList<String> array = new ArrayList<String>();
	
	/**
	 * LeerContenido recibe como parametro el archivo donde estan los datos.
	 * devuelve el texto que esta en la linea. si no se encuentra el archivo
	 * muesta error
	 * 
	 * @param archivo
	 */
	ArrayList<String> leerContenido(String archivo) {
		String texto = "", temp = "", bfRead;
		int i=0;
		try {
			BufferedReader ar = new BufferedReader(new FileReader(archivo));
			while ((bfRead = ar.readLine()) != null) { 
				array.add(bfRead);
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "No se encontro archivo");
			}
		return array;
		}
	/**
	 * 
	 */
	void crear(String dir) {
		int largo,contador;
		String txt1 = null,txt2;
		for (String i : leerContenido(dir)) {
			largo=i.length();
			for (contador =1; contador<largo-2; contador++){ 
				if (i.charAt(contador)==','){
					txt2=i.substring(contador);
					cole.insertar(txt1, txt2);
					arbol.agregarNodo(cole);
				}
				else{
					txt1+=i.charAt(contador);
				}
			}
		}
	}



	
}
