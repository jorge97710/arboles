import javax.swing.JOptionPane;

/**
 * @author JorgeAndres
 * @author CarlosCalderon
 */
public class Principal {
	static Diccionario diccionario = new Diccionario();
	static String tipo = "";

	/**
	 * 
	 */
	static void ejecutar() {
		JOptionPane.showMessageDialog(null, "Bienvenido al diccionario",
				"Bienvenida", JOptionPane.INFORMATION_MESSAGE);
		tipo = JOptionPane.showInputDialog("Ingrese el tipo: ");
		diccionario.crear("C:\\Users\\Carlos\\Desktop\\Hola.txt");
	}

	/**
	 * @param args
	 */
	public static void main(String args[]) {
		ejecutar();
		System.out.println("Busqueda inOrder");

	}
}
