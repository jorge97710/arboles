import java.util.Comparator;

/**
 * @author JorgeAndres
 * @author Carlos Calderon
 * @param <T>
 */
public class NodoArbol<T> {
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

	// Atributos
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
	 * @param dato
	 * @param i
	 * @param d
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
}
