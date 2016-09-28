import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Stack;
/**
 * @author Jorge Azmitia, 15202
 * @author Carlos Calderon, 15219
 * @param <K> Llave
 * @param <V> Valor
 * @Version 2.0
 * Clase que simula el arbol binario
 * Inspirado en :https://www.cs.cmu.edu/~adamchik/15-121/lectures/Trees/code/BST.java
 */
public class ArbolBinario<T extends Comparable<T>> implements Iterable<T> {
	/*Atributos*/
	private NodoArbol<T> raiz;
	private Comparator<T> comparator;
	ArrayList<String> recorrido = new ArrayList<String>();
	
	/**
	 * Inner Class para el iterador
	 * Inspirado en : https://www.cs.cmu.edu/~adamchik/15-121/lectures/Trees/code/BST.java
	 *
	 */
	private class MyIterator implements Iterator<T> {
		Stack<NodoArbol<T>> stk = new Stack<NodoArbol<T>>();

		/**
		 * 
		 */
		public MyIterator() {
			if (raiz != null)
				stk.push(raiz);
		}

		/*
		 * (non-Javadoc)
		 * Revisa si existe un siguiente nodo
		 * @see java.util.Iterator#hasNext()
		 */
		public boolean hasNext() {
			return !stk.isEmpty();
		}

		/*
		 * (non-Javadoc)
		 * 
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

		/*
		 * (non-Javadoc)
		 * Metodo para eliminar
		 * @see java.util.Iterator#remove()
		 */
		public void remove() {

		}
	}// end of MyIterator
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

	// Metodo para insertar un nodo
	/**
	 *Metodo que sirve para agregar un nodo 
	 * @param dato Es el dato a ingresar
	 * @return
	 */
	public boolean agregarNodo(T dato) {
		raiz = insert(raiz, dato);
		return true;
	}

	/**
	 *Metodo que sirve para comparar 2 datos tipo T
	 * @param x Dato 1 a comparar
	 * @param y Dato 2 a comparar
	 * @return
	 */
	private int compare(T x, T y) {
		if (comparator == null)
			return x.compareTo(y);
		else
			return comparator.compare(x, y);
	}

	/**
	 * Metodo para eliminar nodo
	 * @param p	El nodo a eliminar
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
	 *Metodo para eliminar dato
	 * @param toDelete Dato a eliminar
	 */
	public void delete(T toDelete) {
		raiz = delete(raiz, toDelete);
	}

	/*******************
	 *
	 * DELETE
	 *
	 ******************/

	/**
	 * @param r nodo  al llegar genera la busqueda in order
	 */
	private void inOrderHelper(NodoArbol r) {
		if (r != null) {
			inOrderHelper(r.i);
			recorrido.add(r.toString());
			inOrderHelper(r.d);
		}
	}

	/**
	 * Metodo para ordenar en in order
	 * 
	 */
	public void inOrderTraversal() {
		inOrderHelper(raiz);
	}

	/**
	 *Metodo que sirve para insertar un nodo y valor
	 * @param p Nodo a insertar
	 * @param toInsert Elemento a insertar
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

	/*******************
	 *
	 * TREE ITERATOR
	 *
	 ******************/

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Iterable#iterator()
	 */
	public Iterator<T> iterator() {
		return new MyIterator();
	}

	/*****************
	 *
	 * TRAVERSAL
	 *
	 ******************/

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
	 * Metodo para ordenar en Pre-order
	 */
	public void preOrderTraversal() {
		preOrderHelper(raiz);
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

	/**
	 *Metodo para buscar en un arbol un nodo y regresar true si existe
	 * @param p El nodo 
	 * @param toSearch El elemento 
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

	/*******************
	 *
	 * SEARCH
	 *
	 ******************/
	/**
	 * @param toSearch Dato a buscar
	 * @return true si encontro el dato o false si no fue asi
	 */
	public boolean search(T toSearch) {
		return search(raiz, toSearch);
	}

	/*****************
	 *
	 * toString
	 *
	 ******************/

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		StringBuffer sb = new StringBuffer();
		for (T dato : this)
			sb.append(dato.toString());

		return sb.toString();
	}
}