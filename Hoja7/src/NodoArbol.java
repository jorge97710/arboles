import java.util.Comparator;

public class NodoArbol<T> {
	// Atributos
	T dato;
	NodoArbol<T> i;
	NodoArbol<T> d;

	public NodoArbol(T dato, NodoArbol<T> i, NodoArbol<T> d) {
		this.i = i;
		this.d = d;
		this.dato = dato;
	}

	public NodoArbol(T dato) {
		this(dato, null, null);
	}

	public String toString() {
		return dato.toString();
	}

	class MyComp1 implements Comparator<Integer> {
		public int compare(Integer x, Integer y) {
			return y - x;
		}
	}
}
