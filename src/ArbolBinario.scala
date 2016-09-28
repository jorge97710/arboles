import java.util.ArrayList
import java.util.Comparator
import java.util.Iterator
import java.util.Stack
import scala.collection.JavaConversions._

class ArbolBinario[T <: Comparable[T]] extends java.lang.Iterable[T] {

	private var raiz: NodoArbol[T] = null

			private var comparator: Comparator[T] = null

			var recorrido: ArrayList[String] = new ArrayList[String]()

			def this(comp: Comparator[T]) {
	this()
	this.raiz = null
	comparator = comp
}

private def compare(x: T, y: T): Int = {
		if (comparator == null) x.compareTo(y) else comparator.compare(x, y)
}

def agregarNodo(dato: T) {
	raiz = insert(raiz, dato)
}

private def insert(p: NodoArbol[T], toInsert: T): NodoArbol[T] = {
		if (p == null) return new NodoArbol[T](toInsert)
				if (compare(toInsert, p.dato) == 0) return p
						if (compare(toInsert, p.dato) < 0) p.i = insert(p.i, toInsert) else p.d = insert(p.d, toInsert)
						p
}

def search(toSearch: T): Boolean = search(raiz, toSearch)

private def search(p: NodoArbol[T], toSearch: T): Boolean = {
	if (p == null) false else if (compare(toSearch, p.dato) == 0) true else if (compare(toSearch, p.dato) < 0) search(p.i,
			toSearch)
			else search(p.d, toSearch)
}

override def toString(): String = {
		val sb = new StringBuffer()
		for (dato <- this) sb.append(dato.toString)
		sb.toString
}

def inOrderTraversal(): Unit= {
	inOrderHelper(raiz)
}

private def inOrderHelper(r: NodoArbol[T]): Unit= {
	if (r != null) {
		inOrderHelper(r.i)
		recorrido.add(r.toString)
		inOrderHelper(r.d)
	}
}

def iterator(): Iterator[T] = new MyIterator()

private class MyIterator extends Iterator[T] {

	var stk: Stack[NodoArbol[T]] = new Stack[NodoArbol[T]]()

			if (raiz != null) stk.push(raiz)

			def hasNext(): Boolean = !stk.isEmpty

			def next(): T = {
					val cur = stk.peek()
							if (cur.i != null) {
								stk.push(cur.i)
							} else {
								var tmp = stk.pop()
										while (tmp.d == null) {
											if (stk.isEmpty) return cur.dato
													tmp = stk.pop()
										}
								stk.push(tmp.d)
							}
					cur.dato
			}

			def remove() {
			}
}
}
