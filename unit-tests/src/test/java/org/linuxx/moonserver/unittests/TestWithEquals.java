package org.linuxx.moonserver.unittests;

import org.junit.Assert;
import org.junit.Test;

/*
 * Eine Testklasse für jede Klasse, diese sollte genau so heißen, wie die Klasse, die zu testen ist, mit Pre/Postfix 'Test'
 * 
 * Jede öffentliche (nicht private) Funktion sollte getestet werden
 * 
 * Damit Tests nicht ausufern, sollte so programmiert werden, das interne Funktionalität einfachst abgeschnitten werden kann, z.B. durch Mockito
 * Unit Tests sollen nur die eigentliche Unit testen, nicht gleich die ganze Umgebung dazu.
 */
public class TestWithEquals {

	/*
	 * Ein Test beginnt grundsätzlich mit der Annotation @Test Ein Test sollte
	 * einen aussagekräftigen Namen enthalten, nicht unbedingt test1, test2 usw.
	 * 
	 * Testfälle sollten immer gleich aussehen - Szenario aufbauen, - zu
	 * testende Methode ausführen, - prüfen, ob das gewünschte Verhalten
	 * gebracht wird.
	 */

	@Test
	public void testSubString_with_start_end_param() {
		final String value = "subStringTest";

		final String expected = "bStr";
		final String actual = value.substring(2, 4 + 2);

		Assert.assertEquals(expected, actual);
	}

	@Test
	public void testSubString_with_start_param() {
		final String value = "subStringTest";

		final String expected = "Test";
		final String actual = value.substring(9);

		Assert.assertEquals(expected, actual);
	}
}
