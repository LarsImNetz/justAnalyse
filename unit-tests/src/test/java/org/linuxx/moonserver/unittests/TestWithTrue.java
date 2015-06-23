package org.linuxx.moonserver.unittests;

import org.junit.Assert;
import org.junit.Test;

public class TestWithTrue {

	@Test
	public void testNullValue() {
		String a = null;

		Assert.assertTrue(a == null);
	}

	@Test
	public void testNotNullValue() {
		String a = "";

		Assert.assertTrue(a != null);
		Assert.assertFalse(a == null);
	}
}
