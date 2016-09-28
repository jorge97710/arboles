
import java.util.HashMap
//remove if not needed
import scala.collection.JavaConversions._

class Asociacion[K, V]  {

  private var dic: HashMap[K, V] = new HashMap[K, V]()

  def insertar(key: K, value: V) {
    dic.put(key, value)
  }

  def get(key: K): V = dic.get(key)

  def containsKey(key: K): Boolean = {
    if (dic.containsKey(key)) {
      println("Si existe!")
      true
    } else {
      println("No existe!")
      false
    }
  }

  //override def compareTo(o: Asociacion): Int = 0
}
