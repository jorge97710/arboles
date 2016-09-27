import java.util.HashMap;

/*
 *Jorge Azmitia 15202
 *Carlos Calderon 15219
 *Clase que se encarga de hacer las asociaciones entre las palabras
 * 
 * */

/**
 * @author Jorge Andres
 * @author Carlos Calderon
 * @param <K> Llave
 * @param <V> Valor
 */
public class Asociacion<K, V> implements Comparable<Asociacion<K, V>> {

	private HashMap<K, V> dic;

	/**
	 * 
	 */
	public Asociacion() {
		dic = new HashMap<K, V>();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 */
	@Override
	public int compareTo(Asociacion o) {
		// TODO Auto-generated method stub
		return 0;
	}

	/**
	 * @param key Es la llave a la cual se le asocia un valor
	 * @return Falso o Verdadero de pendiendo en si existe una relacion en la que esta sea la llave
	 */
	public boolean containsKey(K key) {
		if (dic.containsKey(key)) {
			System.out.println("Si existe!");
			return true;
		} else {
			System.out.println("No existe!");
			return false;
		}
	}

	/**
	 * @param key  Es la llave a la cual se le asocia un valor
	 * @return dic.get(key) Es el valor que tiene asociado la llave
	 */
	public V get(K key) {
		return dic.get(key);
	}

	/**
	 * @param key  Es la llave a la cual se le asocia un valor
	 * @param value Es el valor a ingresar como asociado a la llave
	 */
	public void insertar(K key, V value) {
		dic.put(key, value);
	}
}