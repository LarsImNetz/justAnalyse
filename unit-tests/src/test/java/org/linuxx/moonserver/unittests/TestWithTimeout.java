package org.linuxx.moonserver.unittests;

import org.junit.Test;

public class TestWithTimeout {

	@Test(timeout = 500)
	public void test() throws InterruptedException {
		Thread.sleep(400);
	}

}
