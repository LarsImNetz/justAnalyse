package org.linux.moonserver.stringformatter;

import org.junit.Assert;
import org.junit.Test;

public class TestStringFormatterWithInteger {

	@Test
	public void testIntegerAlign() {
		final Integer integerValue = 32767;
		Assert.assertEquals("32767", String.format("%d", integerValue));
		Assert.assertEquals("  32767", String.format("%7d", integerValue));
		Assert.assertEquals("32767  ", String.format("%-7d", integerValue));
		Assert.assertEquals("0032767", String.format("%07d", integerValue));
		// ??? Assert.assertEquals("67", String.format("%.2d", integerValue));
	}

}
