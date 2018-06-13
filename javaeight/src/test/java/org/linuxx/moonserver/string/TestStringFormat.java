package org.linuxx.moonserver.string;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestStringFormat {

	@Test
	public void testStringFormat() {
		Long kundennummer = 123_456_789_001_002_003L;
		String plz = "23567";
		String format = String.format("buchen/%d/%s", kundennummer, plz);
		assertEquals("buchen/123456789001002003/23567", format);
	}

}
