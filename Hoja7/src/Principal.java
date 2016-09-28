import javax.swing.JOptionPane;

/**
 * @author JorgeAndres
 * @author carlos calderon
 * @version 2.0
 * Clase principal donde se ejecutan las funciones de busqueda.
 * 
 */
public class Principal {
	static Diccionario diccionario = new Diccionario();
	static String tipo = "";

	/**
	 * Metodo para instaciar la clase Diccionario e invocar las de busqueda in order
	 * y traduccion de oracion.
	 */
	static void ejecutar() {
		JOptionPane.showMessageDialog(null, "Bienvenido al diccionario",
				"Bienvenida", JOptionPane.INFORMATION_MESSAGE);
		tipo = JOptionPane.showInputDialog("Ingrese el directorio donde se encuentran las palabras : ");
		System.out.println("Busqueda inOrder: ");
		diccionario.crear(tipo);
		diccionario.in();
		tipo = JOptionPane.showInputDialog("Ingrese el directorio donde se encuentra la oracion a traducir: ");
		System.out.println("Oracion traducida: ");
		diccionario.buscar(tipo);
	}

	/**
	 * Metodo main
	 * @param args
	 */
	public static void main(String args[]) {
		ejecutar();

	}
}
