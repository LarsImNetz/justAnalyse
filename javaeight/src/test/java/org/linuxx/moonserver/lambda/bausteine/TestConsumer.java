package org.linuxx.moonserver.lambda.bausteine;

import org.junit.Test;

public class TestConsumer {

	/*
	 * Funktionales Interface Consumer
	 * 
	 * Consumer<T> ist eine Funktion, die den Programmzustand durch Seiteneffekte verändert. Ein typisches Nutzungsszenario ist die Verarbeitung von Collections
	 * mit forEach. Die Definition von Consumer zeigt der folgende Code-Ausschnitt:
	 */
	@FunctionalInterface
	public interface Consumer<T> {

		/**
		 * Performs this operation on the given argument.
		 *
		 * @param t
		 *          the input argument
		 */
		public void accept(T t);
	}

	/*
	 * Das nächste Beispiel zeigt Definition und Anwendung eines Consumer:
	 */

	@Test
	public void testConsumer() throws Exception {
		Consumer<String> out = s -> System.out.println(s);
		out.accept("Test");
	}

	/*
	 * Auch hier gilt wieder: Consumer<T>.accept lässt sich direkt (Zeile 2) aufrufen, im Sinne von "Code as Data" ist es jedoch besser, den Consumer<T> als
	 * Lambda-Ausdruck an Stream.foreach zu übergeben:
	 *
	 * forEach ( s -> System.out.println(s), input );
	 *
	 * Ein Consumer wird als Lambda-Ausdruck an die generische forEach-Funktion mit Daten übergeben
	 */

}
