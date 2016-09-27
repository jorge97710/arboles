import java.util.Comparator;

/**
 * @author JorgeAndres
 * @author Carlos Calderon
 * @param <T>
 */
public class NodoArbol<T> {
	// Atributos
	T dato;
	NodoArbol<T> i;
	/**
	 * 
	 */
	NodoArbol<T> d;

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

	/**
	 * @param dato
	 */
	public NodoArbol(T dato) {
		this(dato, null, null);
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		return dato.toString();
	}

	class MyComp1 implements Comparator<Integer> {
		/* (non-Javadoc)
		 * @see java.util.Comparator#compare(java.lang.Object, java.lang.Object)
		 */
		public int compare(Integer x, Integer y) {
			return y - x;
		}
	}
}
