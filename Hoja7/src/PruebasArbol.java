import static org.junit.Assert.*;

import org.junit.Test;
/**
 * @author Jorge Azmitia, 15202
 * @author Carlos Calderon ,15219
 * @Version 2.0
 * Clase para las pruebas unitarias
 */
public class PruebasArbol {
	/* Atributos*/
	public ArbolBinario<String> arbol = new ArbolBinario<String>();

	@Test
	public void testAgregarNodo() {

		if (arbol.agregarNodo("hola"))
			assertEquals(1, 1);
		else
			fail("error");

	}

	@Test
	public void testSearch() {
		arbol.agregarNodo("hola");
		if (arbol.search("hola")) {
			assertEquals(1, 1);

		} else {
			fail("error");
		}

	}

}
