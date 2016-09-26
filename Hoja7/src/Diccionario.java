import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import javax.swing.JOptionPane;


public class Diccionario {
	// Atributos
	private ArbolBinario<String> arbol = new ArbolBinario<String>(); 
	private Asociacion<String,String> cole = new Asociacion<String,String>();
	private Asociacion<String,String> cole2 = new Asociacion<String,String>();
	private ArrayList<String> array = new ArrayList<String>();
	
	/**
	 * LeerContenido recibe como parametro el archivo donde estan los datos.
	 * devuelve el texto que esta en la linea. si no se encuentra el archivo
	 * muesta error
	 * 
	 * @param archivo
	 */
	ArrayList<String> leerContenido(String archivo) {
		String bfRead;
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
		String txt1 = "",txt2,j;
		for (String i : leerContenido(dir)) {
			j=i;
			largo=i.length();
			for (contador =1; contador<largo-2; contador++){ 
				if (i.charAt(contador)==','){
					txt2=i.substring(contador+1,largo-1);
					//System.out.println(txt2);
					cole.insertar(txt1, txt2);
					cole2.insertar(txt1, j);
					//System.out.println("h"+txt1);
					arbol.agregarNodo(txt1);
				}
				else{
					txt1+=i.charAt(contador);
				}
			}
			txt1="";
			txt2="";
		}
	}

	/*
	 * Binary search
	 */
	void in(){
		arbol.inOrderTraversal();
		for(String i: arbol.recorrido){
			System.out.println(cole2.get(i));
		}
	}
	void buscar(String dir){
	int largo,contador;
	for (String i:leerContenido(dir)){
		largo=i.length();
		for (contador =1; contador<largo-2; contador++){ 
			if (i.charAt(contador)==' '){
				
			}
		}
	}
	}
	public static void main(String[] args)
	   {
		Diccionario di = new Diccionario();
	     di.crear("C:\\Users\\Carlos\\Desktop\\Hola.txt");
	     di.in();

	   }
	
}
