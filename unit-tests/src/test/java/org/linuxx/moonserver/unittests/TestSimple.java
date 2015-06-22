package org.linuxx.moonserver.unittests;

import org.junit.Assert;
import org.junit.Test;

/*
 * Eine Testklasse für jede Klasse, diese sollte genau so heißen, wie die Klasse, die zu testen ist, mit Pre/Postfix 'Test'
 * 
 * Jede öffentliche (nicht private) Funktion sollte getestet werden
 *
 * Damit is Tests nicht ausufern, sollte so programmiert werden, das intere Funktionalität einfachst abgeschnitten werden kann, z.B. durch Mockito
 * Unit Tests sollen nur die eigentliche Unit testen, nicht gleich die ganze Umgebung dazu.
 */
public class TestSimple {

	/*
	 * Ein Test beginnt grundsätzlich mit der Annotation @Test Ein Test sollte
	 * einen aussagekräftigen Namen enthalten, nicht unbedingt test1, test2 usw.
	 */
	@Test
	public void testSubString_with_start_end_param() {
		String value = "subStringTest";

		String expected = "bStr";
		String actual = value.substring(2, 4 + 2);
		Assert.assertEquals(expected, actual);
	}

	@Test
	public void testSubString_with_start_param() {
		String value = "subStringTest";

		String expected = "Test";
		String actual = value.substring(9);
		Assert.assertEquals(expected, actual);
	}
}
