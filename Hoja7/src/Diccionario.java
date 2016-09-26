import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import javax.swing.JOptionPane;


public class Diccionario {
	// Atributos
	private ArbolBinario<String> arbol = new ArbolBinario<String>(); 
	private Asociacion<String,String> cole = new Asociacion<String,String>();
	private Asociacion<String,String> cole2 = new Asociacion<String,String>();
	private ArrayList<String> array = new ArrayList<String>();
    static Stack<String> miStack = new Stack<String>();
	private ArrayList<String> array2 = new ArrayList<String>();


    static Stack<String> miStack2 = new Stack<String>();

    static String textoArray[];
	/**
	 * LeerContenido recibe como parametro el archivo donde estan los datos.
	 * devuelve el texto que esta en la linea. si no se encuentra el archivo
	 * muesta error
	 * 
	 * @param archivo
	 */
	ArrayList<String> leerContenido(String archivo) {
		String bfRead;
		try {
			BufferedReader ar = new BufferedReader(new FileReader(archivo));
			while ((bfRead = ar.readLine()) != null) { 
				array.add(bfRead);
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "No se encontro archivo");
			}
		return array;
		}
	
	
	static String leerContenidos(String archivo) {
    	String texto="",temp="",bfRead; 
    	try{
			 BufferedReader ar = new BufferedReader (new FileReader(archivo));
			 while ((bfRead = ar.readLine()) != null){
				 temp+=bfRead;
			 }
			 texto=temp;
		 }catch (Exception e) {
				JOptionPane.showMessageDialog(null, "No se encontro archivo");
				}

		 
		 return texto;
	    }
	/**
	 * 
	 */
	void crear(String dir) {
		int largo,contador;
		String txt1 = "",txt2,j;
		for (String i : leerContenido(dir)) {
			j=i;
			largo=i.length();
			for (contador =1; contador<largo-2; contador++){ 
				if (i.charAt(contador)==','){
					txt2=i.substring(contador+1,largo-1);
					//System.out.println(txt2);
					cole.insertar(txt1, txt2);
					cole2.insertar(txt1, j);
					//System.out.println("h"+txt1);
					arbol.agregarNodo(txt1);
				}
				else{
					txt1+=i.charAt(contador);
				}
			}
			txt1="";
			txt2="";
		}
	}

	/*
	 * Binary search
	 */
	void in(){
		arbol.inOrderTraversal();
		for(String i: arbol.recorrido){
			System.out.println(cole2.get(i));
		}
		//cole2.insertar("new", "nueva");
		//System.out.println(cole.get("ame"));
			System.out.println(arbol.search("ame"));
		
	}
	void buscar(String dir){
	String texto="",a,traduccion="";
	int j=0,k=0;
	texto=leerContenidos(dir);
	textoArray= texto.split(" ");
		for (String i: textoArray){
			a=i.substring(1,i.length());
			array2.add(a);
			array.add(i);
		//	miStack.push(a);
		//	miStack2.push(a);
		//	System.out.println(a);
			k++;
		}
	
		System.out.println(arbol.search("og"));
	
		for (String i:textoArray)
	{
		if(arbol.search(array2.get(j))){
			System.out.println("hay traduccion de "+array2.get(j)+" y es "+cole.get(array2.get(j)));
			traduccion+=cole.get(array2.get(j));
		}else{
			System.out.println("nohay de "+ array2.get(j));
			traduccion+="*"+array2.get(j)+"*";

		}
		j++;
	}
	System.out.println(traduccion);
		
		
	}
	public static void main(String[] args)
	   
	{
		Diccionario di = new Diccionario();
		Diccionario dis = new Diccionario();

	     di.crear("C:\\Users\\JorgeAndres\\Desktop\\Hola.txt");
	     di.in();
	     di.buscar("C:\\Users\\JorgeAndres\\Desktop\\oracion.txt");
	     

	   }
	
}
