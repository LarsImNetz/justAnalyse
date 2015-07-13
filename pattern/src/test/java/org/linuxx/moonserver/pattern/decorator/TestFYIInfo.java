package org.linuxx.moonserver.pattern.decorator;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TestFYIInfo {
	IInformation info;
	
	@Before
	public void setUp() {
		info = new FYIInfo(new Info());
	}
	
	@Test
	public void testGetInfo() throws Exception {	
		final String message = info.getInfo();

		Assert.assertEquals("FYI:some info", message);
	}
}
