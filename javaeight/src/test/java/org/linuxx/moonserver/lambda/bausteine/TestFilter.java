package org.linuxx.moonserver.lambda.bausteine;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import org.junit.Assert;
import org.junit.Test;

public class TestFilter {

	@Test
	public void test() {
		final List<Integer> asList = Arrays.asList(10, 20, 30, 40, 50, 60, 70, 80);
		final Stream<Integer> stream = asList.stream();
		final Object[] array = stream.filter(value -> value > 40).toArray();

		Assert.assertTrue(array.length == 4);
	}

	/*
	 * Das funktionale Interface Function<T,R> transformiert einen Eingabetyp T in einen Ausgabetyp R.
	 * Ein typisches Nutzungsszenario sind Mapper, die Eingabedaten in ein Ausgabedatum transformieren,
	 * konvertieren, berechnen. Eine solche Funktion kam im einleitenden Beispiel bei der Rabattierung als
	 * mapToDouble(price -> price * 0.9) zum Einsatz. Die Definition von Function sieht wie folgender Code-Ausschnitt aus:
	 * 
	 */

	@FunctionalInterface
	interface Function<IN, OUT> {

		OUT apply(IN in);
	}

	@Test
	public void testSquare() throws Exception {
		Function<Integer, Integer> square = n -> n * n;
		Assert.assertEquals(Integer.valueOf(9), square.apply(3));
	}

	/*
	 * square ist eine Abbildung von Integer nach Integer und liefert das Quadrat der übergebenen Zahl zurück.
	 * Eine Anwendung mit Function.apply ist – wie in Zeile 4 gezeigt – möglich. Besser und im Sinne von
	 * "Code as Data" ist aber, die Function<T,R> als Lambda-Ausdruck an die generische Funktion Stream.map zu
	 * übergeben.
	 *
	 * map ( n -> n*n, input );
	 *
	 * Eine Function wird als Lambda-Ausdruck an die generische map-Methode mit Daten übergeben
	 */

}
