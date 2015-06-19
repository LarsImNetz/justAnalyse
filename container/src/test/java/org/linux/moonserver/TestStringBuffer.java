package org.linux.moonserver;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TestStringBuffer {

	StringBuffer buffer;

	@Before
	public void setUp() {
		buffer = new StringBuffer();
		buffer.append("a");
		buffer.append("b");
		buffer.append("c");
	}

	@Test
	public void testToString() {
		String all = buffer.toString();
		Assert.assertEquals("abc", all);
	}

}
