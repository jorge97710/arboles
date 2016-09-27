import static org.junit.Assert.*;

import org.junit.Test;

public class PruebasArbol {
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
