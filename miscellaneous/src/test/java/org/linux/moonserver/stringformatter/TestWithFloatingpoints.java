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
		Assert.assertEquals("1,000000e+03", String.format(Locale.GERMANY, "%e", Double.valueOf(1000d))); // default
		Assert.assertEquals("1e+03", String.format(Locale.GERMAN, "%.0e", Double.valueOf(1000d))); // keine Nachkommastellen
		Assert.assertEquals("1,00e+03", String.format(Locale.GERMAN, "%.2e", Double.valueOf(1000d))); // 2 Nachkommastellen
		Assert.assertEquals("1.000000e+03", String.format(Locale.US, "%e", Double.valueOf(1000d))); // default Englisch (Punkt)
	}

	@Test
	public void testStringFormatFloatF() {
		Assert.assertEquals("1000", String.format(Locale.GERMANY, "%.0f", Double.valueOf(1000.123d)));
		Assert.assertEquals("1000,00", String.format(Locale.GERMANY, "%.2f", Double.valueOf(1000d)));
		Assert.assertEquals("100000,00", String.format(Locale.GERMANY, "%.2f", Double.valueOf(100000d)));
		Assert.assertEquals("10000000,00", String.format(Locale.GERMANY, "%.2f", Double.valueOf(10000000d)));
		Assert.assertEquals("1000000000,00", String.format(Locale.GERMANY, "%.2f", Double.valueOf(1000000000d)));
		Assert.assertEquals("100000000001,00", String.format(Locale.GERMANY, "%.2f", Double.valueOf(100000000001d)));
		Assert.assertEquals("1000,000000", String.format(Locale.GERMANY, "%f", Double.valueOf(1000d))); // default

		// Auf- Abrunden
		Assert.assertEquals("1000,01", String.format(Locale.GERMANY, "%.2f", Double.valueOf(1000.01d)));
		Assert.assertEquals("1000,00", String.format(Locale.GERMANY, "%.2f", Double.valueOf(1000.0049d)));
		Assert.assertEquals("1000,01", String.format(Locale.GERMANY, "%.2f", Double.valueOf(1000.005d)));
		Assert.assertEquals("1000,01", String.format(Locale.GERMANY, "%.2f", Double.valueOf(1000.006d)));

		Assert.assertEquals("1000.00", String.format(Locale.US, "%.2f", Double.valueOf(1000d))); // englisch
	}

	// TODO: mehr Formatierungen
}
