import java.util.Comparator
import scala.collection.JavaConversions._

class NodoArbol[T](var dato: T, var i: NodoArbol[T], var d: NodoArbol[T]) {

var dato1: T = dato;
var i1: NodoArbol[T] = i;
var d1: NodoArbol[T] = d;

def this(dato: T) {
	this(dato, null, null)
}

override def toString(): String = dato.toString

class MyComp1 extends Comparator[Integer] {

	def compare(x: java.lang.Integer, y: java.lang.Integer): Int = y - x
}
}