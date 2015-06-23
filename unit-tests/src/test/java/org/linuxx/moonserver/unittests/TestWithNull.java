package org.linuxx.moonserver.unittests;

import org.junit.Assert;
import org.junit.Test;

public class TestWithNull {

	@Test
	public void testNullValue() {
		String a = null;

		Assert.assertNull(a);
	}

	@Test
	public void testNotNullValue() {
		String a = "";

		Assert.assertNotNull(a);
	}
}
