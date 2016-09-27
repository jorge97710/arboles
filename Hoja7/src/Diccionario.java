import java.io.BufferedReader;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import javax.swing.JOptionPane;

/**
 * @author JorgeAndres
 * @author carlos calderon
 */
public class Diccionario {
	// Atributos
	/**
	 * 
	 */
	private ArbolBinario<String> arbol = new ArbolBinario<String>();
	private Asociacion<String, String> cole = new Asociacion<String, String>();
	private Asociacion<String, String> cole2 = new Asociacion<String, String>();
	private ArrayList<String> array = new ArrayList<String>();
	static Stack<String> miStack = new Stack<String>();
	private ArrayList<String> array2 = new ArrayList<String>();

	static Stack<String> miStack2 = new Stack<String>();

	static String textoArray[];

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
	 * metodo que lee el contenido y lo pone en una sola linea
	 * 
	 * @param archivo
	 * @return
	 */
	static String leerContenidos(String archivo) {
		String texto = "", temp = "", bfRead;
		try {
			BufferedReader ar = new BufferedReader(new FileReader(archivo));
			while ((bfRead = ar.readLine()) != null) {
				temp += bfRead;
			}
			texto = temp;
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "No se encontro archivo");
		}

		return texto;
	}

	/**
	 * 
	 */
	/**
	 * metodo que crea el arbol y relaciones entre palabras
	 * 
	 * @param dir
	 */
	void crear(String dir) {
		int largo, contador;
		String txt1 = "", txt2, j;
		for (String i : leerContenido(dir)) {
			j = i;
			largo = i.length();
			for (contador = 1; contador < largo - 2; contador++) {
				if (i.charAt(contador) == ',') {
					txt2 = i.substring(contador + 1, largo - 1);
					cole.insertar(txt1, txt2);
					cole2.insertar(txt1, j);
					arbol.agregarNodo(txt1);
				} else {
					txt1 += i.charAt(contador);
				}
			}
			txt1 = "";
			txt2 = "";
		}
	}

	/*
	 * Binary search
	 */
	/**
	 * metodo que se encarga de desplegar inorder el arbol
	 */
	void in() {
		arbol.inOrderTraversal();
		for (String i : arbol.recorrido) {
			System.out.println(cole2.get(i));
		}

	}

	/**
	 * metodo que se encarga de primero crear un arraylist que tiene las
	 * palabras en ingles y hace comparaciones para poder ver si existe o no. si
	 * existe cambia la palabra por la que tiene asociada la key. y si no agrega
	 * al texto traducido la palabra en ingles entre asteriscos
	 * 
	 * @param dir
	 */
	void buscar(String dir) {
		String texto = "", a, traduccion = "";
		int j = 0, k = 0;
		texto = leerContenidos(dir);
		textoArray = texto.split(" ");
		for (String i : textoArray) {
			array2.add(i);
			array.add(i);
			k++;
		}

		for (String i : textoArray) {
			if (arbol.search(array2.get(j))) {
				traduccion += cole.get(array2.get(j));
			} else {
				traduccion += "*" + array2.get(j) + "*";

			}
			j++;
		}
		System.out.println(traduccion);

	}

	/**
	 * metodo main
	 * 
	 * @param args
	 */
	public static void main(String[] args)

	{
		Diccionario di = new Diccionario();

		di.crear("C:\\Users\\JorgeAndres\\Desktop\\Hola.txt");
		di.in();
		di.buscar("C:\\Users\\JorgeAndres\\Desktop\\oracion.txt");

	}

}
