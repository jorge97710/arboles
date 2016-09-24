import java.util.HashMap;

public class Asociacion<K,V> {
	
	
	private HashMap<K,V> dic;
	private Palabra palabra = new Palabra();
	
	public Asociacion(){
		dic = new HashMap<K,V>();
	}
	
	
	public void insertar(K key, V value){
		dic.put(key, value);
	}
	
	
	public V get(K key){
		return dic.get(key);
	}
	
	
	public boolean containsKey(){
		if(dic.containsKey(palabra.getIngles())){
		    System.out.println("Si existe!");
		    return true;
		}else{
		    System.out.println("No existe!");
		    return false;
		}
	}
}