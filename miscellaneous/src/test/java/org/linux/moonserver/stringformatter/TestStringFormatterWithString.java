package org.linux.moonserver.stringformatter;

import org.junit.Assert;
import org.junit.Test;

public class TestStringFormatterWithString {

	/*
	 * Format String Systax
	 * %[argument_index$][flags][width][.precision]conversion
	 */

	@Test
	public void testStringFormatBoolean() {
		Assert.assertEquals("true false", String.format("%1$b %2$b", true, false));
		Assert.assertEquals("true", String.format("%b", true));
		Assert.assertEquals("false", String.format("%b", false));
	}

	@Test
	public void testStringFormatHash() {
		Assert.assertEquals("808a33a5", String.format("%1$h", Double.valueOf(3.1415d)));
		Assert.assertEquals("808a33a5", String.format("%h", Double.valueOf(3.1415d)));
	}

	@Test
	public void testStringFormatString() {
		final String title1 = "string";
		Assert.assertEquals("string", String.format("%s", title1));
	}

	@Test
	public void testStringFormatUnicode() {
		Assert.assertEquals("ä", String.format("%c", 'ä'));
	}

	@Test
	public void testStringFormatDouble() {
		Assert.assertEquals("3", String.format("%d", Integer.valueOf(3)));
		Assert.assertEquals("  3", String.format("%3d", Integer.valueOf(3)));
	}

	@Test
	public void testStringFormatOctal() {
		Assert.assertEquals("7", String.format("%o", Integer.valueOf(7)));
		Assert.assertEquals("10", String.format("%o", Integer.valueOf(8)));
	}

	@Test
	public void testStringFormatHexa() {
		Assert.assertEquals("a", String.format("%x", Integer.valueOf(10)));
		Assert.assertEquals("affe", String.format("%4x", Integer.valueOf(0xaffe)));
	}

	@Test
	public void testStringAlignment() {
		final String title1 = "Column 1";
		Assert.assertEquals("Column 1    ", String.format("%-12s", title1));
		Assert.assertEquals("    Column 1", String.format("%12s", title1));

		// Es wird nichts abgeschnitten
		Assert.assertEquals("Column 1", String.format("%4s", title1));
		Assert.assertEquals("Column 1", String.format("%-4s", title1));
	}

	@Test
	public void testStringWithParameter() throws Exception {
		final String string1 = "parameter1";
		final String string2 = "parameter2";
		final String s = String.format("%2$s %1$s", string1, string2);
		Assert.assertEquals("parameter2 parameter1", s);
	}
}
