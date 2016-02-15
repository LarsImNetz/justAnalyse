package experiment.lars.java.number;

import java.text.NumberFormat;
import java.util.Locale;

import org.junit.Assert;
import org.junit.Test;



public class TestNumberFormat {

	@Test
	public void test_1() {
		long number = 1L;
		String format = NumberFormat.getInstance(Locale.GERMAN).format(number);
		Assert.assertEquals("1", format);
	}
	@Test
	public void test_10() {
		long number = 10L;
		String format = NumberFormat.getInstance(Locale.GERMAN).format(number);
		Assert.assertEquals("10", format);
	}
	@Test
	public void test_100() {
		long number = 100L;
		String format = NumberFormat.getInstance(Locale.GERMAN).format(number);
		Assert.assertEquals("100", format);
	}
	@Test
	public void test_1000() {
		long number = 1_000L;
		String format = NumberFormat.getInstance(Locale.GERMAN).format(number);
		Assert.assertEquals("1.000", format);
	}
	@Test
	public void test_10000() {
		long number = 10_000L;
		String format = NumberFormat.getInstance(Locale.GERMAN).format(number);
		Assert.assertEquals("10.000", format);
	}
	@Test
	public void test_100000() {
		long number = 100_000L;
		String format = NumberFormat.getInstance(Locale.GERMAN).format(number);
		Assert.assertEquals("100.000", format);
	}
	@Test
	public void test_1000000() {
		long number = 1_000_000L;
		String format = NumberFormat.getInstance(Locale.GERMAN).format(number);
		Assert.assertEquals("1.000.000", format);
	}

}
