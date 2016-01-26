package org.homenet.moonserver.kontoimporter.buchung;

import org.junit.Assert;
import org.junit.Test;

public class TestCSVLineSplitter {

	CSVLineSplitter splitter = new CSVLineSplitter();

	@Test
	public void testNull() throws Exception {
		Assert.assertNull(splitter.split(null));
	}

	@Test
	public void testEmptyString() throws Exception {
		final String[] expected = {""};
		final String[] actual = splitter.split("");
		Assert.assertEquals(expected[0], actual[0]);
	}

	@Test
	public void testSingleValue() throws Exception {
		final String[] expected = {"value"};
		final String[] actual = splitter.split("value");
		Assert.assertEquals(expected[0], actual[0] );
	}

	// TODO Hamcrest!
	@Test
	public void testTwoValues() throws Exception {
		final String[] expected = {"one", "two"};
		final String[] actual = splitter.split("one;two");
		Assert.assertEquals(expected[0], actual[0] );
		Assert.assertEquals(expected[1], actual[1] );
	}
}
