package org.linuxx.moonserver.unittests;

import org.junit.Test;
import org.linuxx.moonserver.utils.StringUtils;

public class TestWithException {

	@Test(expected = IllegalArgumentException.class)
	public void testNull() {

		new StringUtils().reverse(null);
	}
}
