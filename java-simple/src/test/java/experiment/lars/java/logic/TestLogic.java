package experiment.lars.java.logic;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


/**
 * Logiktests, gerade wie häufig Funktionen aufgerufen werden, wenn die Bedingung schon erfüllt ist.
 */
public class TestLogic {

	private int trueCounter = 0;
	private int falseCounter = 0;

	@Before
	public void setUp() {
		trueCounter = 0;
		falseCounter = 0;
	}

	@Test
	public void testTrue() {
		boolean value = isTrue();

		Assert.assertTrue(value);
		
		Assert.assertEquals(trueCounter, 1);
		Assert.assertEquals(falseCounter, 0);
	}

	@Test
	public void testFalse() {
		boolean value = isFalse();

		Assert.assertFalse(value);
		
		Assert.assertEquals(falseCounter, 1);
		Assert.assertEquals(trueCounter, 0);
	}

	@Test
	public void testTrueOrFalse() {
		boolean value = isTrue() || isFalse();

		Assert.assertTrue(value);
		
		Assert.assertEquals(trueCounter, 1);
		Assert.assertEquals(falseCounter, 0);
	}

	// Die Reihenfolge ist ok
	@Test
	public void testTrueOrFalseOrTrue() {
		boolean value = isTrue() || isFalse() || isTrue();

		Assert.assertTrue(value);
		
		Assert.assertEquals(trueCounter, 1);
		Assert.assertEquals(falseCounter, 0);
	}

	// Reihenfolge sehr ungeschickt
	@Test
	public void testFalseOrFalseOrTrue() {
		boolean value = isFalse() || isFalse() || isTrue();

		Assert.assertTrue(value);
		
		Assert.assertEquals(trueCounter, 1);
		Assert.assertEquals(falseCounter, 2);
	}

	// Reihenfolge noch ungeschickt
	@Test
	public void testFalseOrTrueOrFalse() {
		boolean value = isFalse() || isTrue() || isFalse();

		Assert.assertTrue(value);
		
		Assert.assertEquals(trueCounter, 1);
		Assert.assertEquals(falseCounter, 1);
	}
	
	@Test
	public void testNotTrueOrFalse() {
		boolean value = !isTrue() || isFalse();

		Assert.assertFalse(value);
		
		Assert.assertEquals(trueCounter, 1);
		Assert.assertEquals(falseCounter, 1);
	}

	@Test
	public void testNotFalseOrFalse() {
		boolean value = !isFalse() || isFalse();

		Assert.assertTrue(value);
		
		Assert.assertEquals(falseCounter, 1);
	}

	@Test
	public void testTrueAndFalse() {
		boolean value = isTrue() && isFalse();

		Assert.assertFalse(value);
		
		Assert.assertEquals(trueCounter, 1);
		Assert.assertEquals(falseCounter, 1);
	}

	@Test
	public void testTrueAndFalseAndTrue() {
		boolean value = isTrue() && isFalse() && isTrue();

		Assert.assertFalse(value);
		
		Assert.assertEquals(trueCounter, 1);
		Assert.assertEquals(falseCounter, 1);
	}

	@Test
	public void testFalseAndTrueAndTrue() {
		boolean value = isFalse() && isTrue() && isTrue();

		Assert.assertFalse(value);
		
		Assert.assertEquals(falseCounter, 1);
		Assert.assertEquals(trueCounter, 0);
	}

	private boolean isTrue() {
		trueCounter++;
		return true;
	}

	private boolean isFalse() {
		falseCounter++;		
		return false;
	}
}
