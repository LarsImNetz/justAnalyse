package org.linux.moonserver.stringformatter;

import java.util.Locale;

import org.junit.Assert;
import org.junit.Test;

public class TestWithFloatingpoints {

	@Test
	public void test() {
		final double value = 1001.123d;
		Assert.assertEquals("1001", String.format("%.0f", value));
		Assert.assertEquals("1e+03", String.format("%.0g", value));
	}

	@Test
	public void testStringFormatFloatE() {
		Assert.assertEquals("1,000000e+03", String.format(Locale.GERMANY, "%e", Double.valueOf(1000d)));
		Assert.assertEquals("1e+03", String.format(Locale.GERMAN, "%.0e", Double.valueOf(1000d)));
		Assert.assertEquals("1,00e+03", String.format(Locale.GERMAN, "%.2e", Double.valueOf(1000d)));
		Assert.assertEquals("1.000000e+03", String.format(Locale.US, "%e", Double.valueOf(1000d)));
	}
	@Test
	public void testStringFormatFloatF() {			
		Assert.assertEquals("1000", String.format(Locale.GERMANY, "%.0f", Double.valueOf(1000d)));
		Assert.assertEquals("1000,00", String.format(Locale.GERMANY, "%.2f", Double.valueOf(1000d)));
		Assert.assertEquals("1000.00", String.format(Locale.US, "%.2f", Double.valueOf(1000d)));
		Assert.assertEquals("1000,000000", String.format(Locale.GERMANY, "%f", Double.valueOf(1000d)));
	}

	// TODO: mehr Formatierungen
}
