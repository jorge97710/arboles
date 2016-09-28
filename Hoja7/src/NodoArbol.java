import java.util.Comparator;

/**
 * @author Jorge Azmitia, 15202
 * @author Carlos Calderon ,15219
 * @param <T>
 * @Version 2.0
 * Clase que simula el nodo del arbol binario
 */
public class NodoArbol<T> {
	
	/* Atributos*/
	T dato;
	NodoArbol<T> i;
	NodoArbol<T> d;

	/**
	 * @param dato Es el dato de tipo T a guardar como nodo
	 */
	public NodoArbol(T dato) {
		this(dato, null, null);
	}

	/**
	 * @param dato dato contenido en el nodo
	 * @param i nodo de la izquierda
	 * @param d nodo de la derecha
	 */
	public NodoArbol(T dato, NodoArbol<T> i, NodoArbol<T> d) {
		this.i = i;
		this.d = d;
		this.dato = dato;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		return dato.toString();
	}
	/**
	 * Inner class para utilizar compare
	 */
	class MyComp1 implements Comparator<Integer> {
		/*
		 * (non-Javadoc)
		 * 
		 * @see java.util.Comparator#compare(java.lang.Object, java.lang.Object)
		 */
		public int compare(Integer x, Integer y) {
			return y - x;
		}
	}
}
