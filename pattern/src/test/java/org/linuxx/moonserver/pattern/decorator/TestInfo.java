package org.linuxx.moonserver.pattern.decorator;

import org.junit.Assert;
import org.junit.Test;

public class TestInfo {
	@Test
	public void testGetInfo() throws Exception {
		final IInformation info = new Info();

		final String actual = info.getInfo();
		Assert.assertEquals("some info", actual);
	}
}
