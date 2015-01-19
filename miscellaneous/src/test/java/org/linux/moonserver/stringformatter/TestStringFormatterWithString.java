package org.linux.moonserver.stringformatter;

import org.junit.Assert;
import org.junit.Test;

public class TestStringFormatterWithString {
	@Test
	public void testString() {
		String title1 = "Column 1";
		Assert.assertEquals("Column 1    ", String.format("%-12s", title1));
		Assert.assertEquals("    Column 1", String.format("%12s", title1));

		// Es wird nichts abgeschnitten
		Assert.assertEquals("Column 1", String.format("%4s", title1));
		Assert.assertEquals("Column 1", String.format("%-4s", title1));
	}
}
