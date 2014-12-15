package org.linuxx.moonserver.java7;


import org.junit.Assert;
import org.junit.Test;

public class TestNumeric {

	@Test
	public void test() {
		Assert.assertEquals(1_000_000d, 1000000d, 1); // Numerics can have _ (Underscore)

		Assert.assertEquals(0b1010101, 1 + 4 + 16 + 64); // Binary
	}

}
