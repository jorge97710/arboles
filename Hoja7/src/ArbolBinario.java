import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Stack;

public class ArbolBinario<T extends Comparable<T>> implements Iterable<T> {
	private NodoArbol<T> raiz;
	private Comparator<T> comparator;
	ArrayList<String> recorrido = new ArrayList<String>();

	/**
	 * 
	 */
	public ArbolBinario() {
		this.raiz = null;
		this.comparator = null;
	}

	/**
	 * @param comp
	 */
	public ArbolBinario(Comparator<T> comp) {
		this.raiz = null;
		comparator = comp;
	}

	/**
	 * @param x
	 * @param y
	 * @return
	 */
	private int compare(T x, T y) {
		if (comparator == null)
			return x.compareTo(y);
		else
			return comparator.compare(x, y);
	}

	// Metodo para insertar un nodo
	/**
	 * @param dato
	 */
	public void agregarNodo(T dato) {
		raiz = insert(raiz, dato);
	}

	/**
	 * @param p
	 * @param toInsert
	 * @return
	 */
	private NodoArbol<T> insert(NodoArbol<T> p, T toInsert) {
		if (p == null)
			return new NodoArbol<T>(toInsert);

		if (compare(toInsert, p.dato) == 0)
			return p;

		if (compare(toInsert, p.dato) < 0)
			p.i = insert(p.i, toInsert);
		else
			p.d = insert(p.d, toInsert);

		return p;
	}

	/*****************************************************
	 *
	 * SEARCH
	 *
	 ******************************************************/
	/**
	 * @param toSearch
	 * @return
	 */
	public boolean search(T toSearch) {
		return search(raiz, toSearch);
	}

	/**
	 * @param p
	 * @param toSearch
	 * @return
	 */
	private boolean search(NodoArbol<T> p, T toSearch) {
		if (p == null)
			return false;
		else if (compare(toSearch, p.dato) == 0)
			return true;
		else if (compare(toSearch, p.dato) < 0)
			return search(p.i, toSearch);
		else
			return search(p.d, toSearch);
	}

	/*****************************************************
	 *
	 * DELETE
	 *
	 ******************************************************/

	/**
	 * @param toDelete
	 */
	public void delete(T toDelete) {
		raiz = delete(raiz, toDelete);
	}

	/**
	 * @param p
	 * @param toDelete
	 * @return
	 */
	private NodoArbol<T> delete(NodoArbol<T> p, T toDelete) {
		if (p == null)
			throw new RuntimeException("cannot delete.");
		else if (compare(toDelete, p.dato) < 0)
			p.i = delete(p.i, toDelete);
		else if (compare(toDelete, p.dato) > 0)
			p.d = delete(p.d, toDelete);
		else {
			if (p.i == null)
				return p.d;
			else if (p.d == null)
				return p.i;
			else {
				// get data from the rightmost NodoArbol in the left subtree
				p.dato = retrieveData(p.i);
				// delete the rightmost NodoArbol in the left subtree
				p.i = delete(p.i, p.dato);
			}
		}
		return p;
	}

	/**
	 * @param p
	 * @return
	 */
	private T retrieveData(NodoArbol<T> p) {
		while (p.d != null)
			p = p.d;

		return p.dato;
	}

	/*************************************************
	 *
	 * toString
	 *
	 **************************************************/

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		StringBuffer sb = new StringBuffer();
		for (T dato : this)
			sb.append(dato.toString());

		return sb.toString();
	}

	/*************************************************
	 *
	 * TRAVERSAL
	 *
	 **************************************************/

	/**
	 * 
	 */
	public void preOrderTraversal() {
		preOrderHelper(raiz);
	}

	/**
	 * @param r
	 */
	private void preOrderHelper(NodoArbol r) {
		if (r != null) {
			// System.out.print(r+" ");

			preOrderHelper(r.i);
			preOrderHelper(r.d);
		}
	}

	/**
	 * 
	 */
	public void inOrderTraversal() {
		inOrderHelper(raiz);
	}

	/**
	 * @param r
	 */
	private void inOrderHelper(NodoArbol r) {
		if (r != null) {
			inOrderHelper(r.i);

			// System.out.print(r+" ");
			recorrido.add(r.toString());
			inOrderHelper(r.d);
		}
	}

	/*****************************************************
	 *
	 * TREE ITERATOR
	 *
	 ******************************************************/

	/* (non-Javadoc)
	 * @see java.lang.Iterable#iterator()
	 */
	public Iterator<T> iterator() {
		return new MyIterator();
	}

	// pre-order
	private class MyIterator implements Iterator<T> {
		Stack<NodoArbol<T>> stk = new Stack<NodoArbol<T>>();

		/**
		 * 
		 */
		public MyIterator() {
			if (raiz != null)
				stk.push(raiz);
		}

		/* (non-Javadoc)
		 * @see java.util.Iterator#hasNext()
		 */
		public boolean hasNext() {
			return !stk.isEmpty();
		}

		/* (non-Javadoc)
		 * @see java.util.Iterator#next()
		 */
		public T next() {
			NodoArbol<T> cur = stk.peek();
			if (cur.i != null) {
				stk.push(cur.i);
			} else {
				NodoArbol<T> tmp = stk.pop();
				while (tmp.d == null) {
					if (stk.isEmpty())
						return cur.dato;
					tmp = stk.pop();
				}
				stk.push(tmp.d);
			}

			return cur.dato;
		}// end of next()

		/* (non-Javadoc)
		 * @see java.util.Iterator#remove()
		 */
		public void remove() {

		}
	}// end of MyIterator
}
