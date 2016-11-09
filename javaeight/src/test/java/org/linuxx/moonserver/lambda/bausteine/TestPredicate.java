package org.linuxx.moonserver.lambda.bausteine;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestPredicate {
	/*
	 * Funktionales Interface Predicate: Nutzung als Filter
	 * 
	 * Predicate<T> ist eine Funktion, die ein Objekt vom Typ T einem logischen Testkriterium
	 * unterzieht und damit ein Spezialfall von Function mit Rückgabeergebnis vom Typ boolean.
	 * Ein typisches Nutzungsszenario für Predicate<T>-Instanzen ist die Filterung von Collections.
	 * Ein solches Predicate enthielt bereits das einleitende Beispiel bei der Filterung als
	 * filter(price -> price >= 42). Die Definition von Predicate sieht wie folgt aus:
	 * 
	 * @FunctionalInterface
	 * public interface Predicate<T> {
	 * boolean test(T t);
	 * default Predicate<T> and(...) { ... }
	 * default Predicate<T> negate() { ... }
	 * default Predicate<T> or(...) { ... }
	 * default Predicate<T> xor(...) { ... }
	 * }
	 * Predicate kodiert also ein Testkriterium mit Rückgabewert als boolesches Testergebnis.
	 * Man kann Instanzen über booleschen Operatoren verknüpfen, um komplexere Testkriterien
	 * zu erhalten, etwa wie folgt:
	 */

	@FunctionalInterface
	public interface Predicate<T> {

		boolean test(T t);

		default Predicate<T> negate() {
			return egal -> !test(egal);
		}

		// WTF!
		// default Predicate<T> and(...) {...}
		// default Predicate<T> or(...) {...}
		// default Predicate<T> xor(...) {...}

		default Predicate<T> and(Predicate<T> other) {
			return egal -> test(egal) && other.test(egal);
		}

		default Predicate<T> or(Predicate<T> other) {
			return egal -> test(egal) || other.test(egal);
		}

	}

	@Test
	public void testIsEven() throws Exception {
		Predicate<Integer> isEven = n -> n % 2 == 0;
		assertTrue(isEven.test(2));

		Predicate<Integer> isOdd = isEven.negate();
		assertFalse(isOdd.test(2));
		assertTrue(isOdd.test(1));
		assertTrue(isOdd.test(3));
	}

	@Test
	public void testPositiv() throws Exception {
		Predicate<Integer> isPositive = n -> n > 0;
		Predicate<Integer> isEven = n -> n % 2 == 0;

		Predicate<Integer> isEvenAndPositive = isEven.and(isPositive);
		assertTrue(isEvenAndPositive.test(2)); // true
		assertFalse(isEvenAndPositive.test(3)); // ! even
		assertFalse(isEvenAndPositive.test(-2)); // ! positiv
		assertFalse(isEvenAndPositive.test(-1)); // ! positiv
		assertFalse(isEvenAndPositive.test(0)); // ! positiv
		assertTrue(isEvenAndPositive.test(4)); // true
		assertFalse(isEvenAndPositive.test(5)); // ! even
	}
	
	@Test
	public void testZero() throws Exception {
		Predicate<Integer> isPositive = n -> n > 0;
		Predicate<Integer> isZero = n -> n == 0;

		Predicate<Integer> isZeroOrPositive = isPositive.or(isZero);
		assertTrue(isZeroOrPositive.test(0));
		assertTrue(isZeroOrPositive.test(1));

		assertFalse(isZeroOrPositive.test(-1));
	}

	/*
	 * Auch Predicate<T>.test lässt sich direkt aufrufen, empfehlenswert ist aber auch hier die
	 * Übergabe des Predicate<T> als Lambda-Ausdruck an Stream.filter.
	 *
	 * filter( n -> n % 2 == 0, input );
	 * 
	 * Ein Predicate wird als Lambda-Ausdruck an die generische Filter-Funktion mit Daten übergeben
	 */
}
