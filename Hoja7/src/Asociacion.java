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
 * @param <K>
 * @param <V>
 */
public class Asociacion<K, V> implements Comparable<Asociacion<K, V>> {

	private HashMap<K, V> dic;

	/**
	 * 
	 */
	public Asociacion() {
		dic = new HashMap<K, V>();
	}

	/**
	 * @param key
	 * @param value
	 */
	public void insertar(K key, V value) {
		dic.put(key, value);
	}

	/**
	 * @param key
	 * @return
	 */
	public V get(K key) {
		return dic.get(key);
	}

	/**
	 * @param key
	 * @return
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

	/* (non-Javadoc)
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 */
	@Override
	public int compareTo(Asociacion o) {
		// TODO Auto-generated method stub
		return 0;
	}
}