import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Stack;

import javax.swing.JOptionPane;

/**
 * @author JorgeAndres
 * @author carlos calderon
 * @version 1
 * 
 */
public class Diccionario {
	static Stack<String> miStack = new Stack<String>();
	static Stack<String> miStack2 = new Stack<String>();
	static String textoArray[];

	/**
	 * Metodo que lee el contenido y lo pone en una sola linea. Este es con el
	 * que se lee el texto que viene en ingles
	 * 
	 * @param archivo
	 *            El archivo que tiene el texto en ingles
	 * @return texto variable que tiene como un string todo el texto
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
	 * Metodo main
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

	// Atributos
	/**
	 * 
	 */
	private ArbolBinario<String> arbol = new ArbolBinario<String>();

	private Asociacion<String, String> cole = new Asociacion<String, String>();

	private Asociacion<String, String> cole2 = new Asociacion<String, String>();

	private ArrayList<String> array = new ArrayList<String>();

	private ArrayList<String> array2 = new ArrayList<String>();

	/**
	 * Metodo que se encarga de primero crear un arraylist que tiene las
	 * palabras en ingles. luego hace comparaciones para poder ver si la palabra
	 * en ingles existe o no dentro de las palabras con relaciones existentes.
	 * si la palabra si esta dentro de los nodos del arbol entonces se obtiene
	 * el valor al cual esta asociada esa llave(la palabra en ingles) al String
	 * traduccion. si esta palabra no se encuentra, simplemente se toma del
	 * arraylist que tiene todas las palabras en ingles, se pone dentro de
	 * asteriscos y se agrega a el String traduccion
	 * 
	 * 
	 * @param dir
	 *            El directorio del archivo que tiene el texto en ingles
	 */
	void buscar(String dir) {
		String texto = "", traduccion = "";
		int j = 0;
		texto = leerContenidos(dir);
		textoArray = texto.split(" ");
		for (String i : textoArray) {
			array2.add(i);

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
	 * Metodo que crea el arbol, agregando en este solamente las palabras en
	 * ingles y a su vez generando las relaciones entre palabras en ingles y
	 * español
	 * 
	 * @param dir
	 *            Es el directorio donde se encuentra el archivo que las tiene
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

	/**
	 * Metodo que ordena de forma "in-order" todos los nodos del arbol. Luego de
	 * ser ordenados estos se imprimen
	 */
	void in() {
		arbol.inOrderTraversal();
		for (String i : arbol.recorrido) {
			System.out.println(cole2.get(i));
		}

	}

	/**
	 * LeerContenido recibe como parametro el archivo donde estan los datos.
	 * devuelve el texto que esta en la linea. si no se encuentra el archivo
	 * muesta error
	 * 
	 * @param archivo
	 *            Este es el archivo que contiene las palabras de forma
	 *            (ingles,español)
	 * @return array este es un array que tiene las palabras
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

}
