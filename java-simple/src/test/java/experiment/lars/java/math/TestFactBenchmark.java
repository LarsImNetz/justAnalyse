package experiment.lars.java.math;

import java.math.BigInteger;

import org.junit.Assert;
import org.junit.Test;

public class TestFactBenchmark {

	@Test
	public void testFirst() throws Exception {
		final BigInteger expect = new BigInteger("1");
		Assert.assertEquals(expect, fact(1));
	}

	@Test
	public void testSecond() throws Exception {
		final BigInteger expect = new BigInteger("2"); // 1 * 2
		Assert.assertEquals(expect, fact(2));
	}

	@Test
	public void testThree() throws Exception {
		final BigInteger expect = new BigInteger("6"); // 1 * 2 * 3
		Assert.assertEquals(expect, fact(3));
	}

	/**
	 * Leider keine Fakultät von 2000 mit BigInteger.toString() in Eclipse anzeigbar
	 */
	@Test
	public void testTimeFor1676() {
		final long start = System.currentTimeMillis();
		final int n = 1676;
		final BigInteger grosseZahl = fact(n);
		final long end = System.currentTimeMillis();
		final long time = end - start;
		System.out.println("Time: " + time + "ms   fact(" + n + ") := " + grosseZahl.toString());
	}

	private static BigInteger fact(final int n) {
		BigInteger facultaet = BigInteger.ONE;
		BigInteger bigN = BigInteger.ONE;
		for (int i = 1; i <= n; i++) {
			facultaet = facultaet.multiply(bigN);
			bigN = bigN.add(BigInteger.ONE);
		}
		return facultaet;
	}
}
