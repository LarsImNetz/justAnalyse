package org.linuxx.moonserver.bigint;

import java.math.BigInteger;

import org.junit.Assert;
import org.junit.Test;

public class TestBigInt {

	@Test
	public void test() {
		BigInteger a = new BigInteger("2");
		BigInteger b = BigInteger.valueOf(2L);
		
		BigInteger c = a.multiply(b);
		
		Assert.assertEquals("4", c.toString(10));
	}
}
