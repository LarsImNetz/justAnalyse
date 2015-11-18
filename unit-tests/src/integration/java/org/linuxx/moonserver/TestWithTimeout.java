package org.linuxx.moonserver;

import org.junit.Assert;
import org.junit.Test;

public class TestWithTimeout {

	@Test(timeout = 500)
	public void test() throws InterruptedException {
		Thread.sleep(400);
	}

	@Test(timeout = 1000)
	public void testReallyStupid() {
		final long BIGVALUE = 250000000L;
		long j = 0;
		for (long i=0;i<BIGVALUE;i++) {
			j++;
		}
		Assert.assertEquals(BIGVALUE, j);
	}
}
