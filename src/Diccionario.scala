import java.io.BufferedReader

import java.io.FileReader
import java.util.ArrayList
import java.util.List
import java.util.Stack
import javax.swing.JOptionPane
import scala.collection.JavaConversions._


class Diccionario {

	    var arbol: ArbolBinario[String] = new ArbolBinario[String]();

			 var cole: Asociacion[String, String] = new Asociacion[String, String]();

			 var cole2: Asociacion[String, String] = new Asociacion[String, String]();

	     var array: ArrayList[String] = new ArrayList[String]()

			private var array2: ArrayList[String] = new ArrayList[String]()
			def leerContenido(archivo: String): ArrayList[String] = {
				var bfRead: String = null
						try {
							val ar = new BufferedReader(new FileReader(archivo))
							while ((bfRead = ar.readLine()) != null) {
								array.add(bfRead)
							}
						} catch {
						case e: Exception => JOptionPane.showMessageDialog(null, "No se encontro archivo")
						}
			array
			}
			def crear(dir: String):Unit= {
				var largo =0
						var contador: Int = 0
						var txt1 = ""
						var txt2: String = null
						var j: String = null
						for (i <- leerContenido(dir)) {
							j = i
									largo = i.length
									contador = 1
									while (contador < largo - 2) {
										if (i.charAt(contador) == ',') {
											txt2 = i.substring(contador + 1, largo - 1)
													cole.insertar(txt1, txt2)
													cole2.insertar(txt1, j)
													arbol.agregarNodo(txt1)
										} else {
											txt1 += i.charAt(contador)
										}
										contador += 1
									}
							txt1 = ""
									txt2 = ""
						}
			}

			def in() {
				arbol.inOrderTraversal()
				for (i <- arbol.recorrido) {
					println(cole2.get(i))
				}
			}
					def leerContenidos(archivo: String): String = {
					var texto = ""
							var temp = ""
							var bfRead: String = null
							try {
								val ar = new BufferedReader(new FileReader(archivo))
								while ((bfRead = ar.readLine()) != null) {
									temp += bfRead
								}
								texto = temp
							} catch {
							case e: Exception => JOptionPane.showMessageDialog(null, "No se encontro archivo")
							}
					texto
			}

			def buscar(dir: String):Unit= {
				var texto =  ""
				//var textoArray= ""
				var textoArray = new Array[String](1)
						var a: String = null
						var traduccion = ""
						var j = 0
						var k = 0
						texto = leerContenidos(dir)
						textoArray = texto.split(" ")
						for (i <- textoArray) {
							array.add(i)
							array.add(i);
							k += 1
						}
				for (i <- textoArray) {
					if (arbol.search(array2.get(j))) {
						traduccion += cole.get(array2.get(j))
					} else {
						traduccion += "*" + array2.get(j) + "*"
					}
					j += 1
				}
				println(traduccion)
			}
			
			
}
