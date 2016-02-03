package org.homenet.moonserver.kontoimporter.filehelper;

import static org.junit.Assert.*;

import java.nio.charset.Charset;

import org.junit.Assert;
import org.junit.Test;

public class TestCharsetIdentifier {
	@Test
	public void testSimpleAscii() throws Exception {
		CharsetIdentifier identifier = new CharsetIdentifier("a".getBytes());
		Assert.assertTrue(identifier.determineISO_8859());
	}

	@Test
	public void testSimpleAscii2() throws Exception {
		CharsetIdentifier identifier = new CharsetIdentifier(
				"abcdefghijklmnopqrstuvxyzABCDEEFGHIJKLMNOPQRSTUVWXYZ1234567890!\"$%&/()=#+'*~,.-;:_<>|@".getBytes());
		Assert.assertTrue(identifier.determineISO_8859());
	}

	@Test
	public void test7ISO8859Umlauts() throws Exception {
		byte[] bytes = "ÄÖÜäöüß".getBytes("ISO-8859-1");
		Assert.assertEquals(7, bytes.length);
	}

	@Test
	public void test7UTF8Umlauts() throws Exception {
		byte[] bytes = "ÄÖÜäöüß".getBytes("UTF-8");
		Assert.assertEquals(14, bytes.length);
	}


	@Test
	public void testISO8859Ascii() throws Exception {
		CharsetIdentifier identifier = new CharsetIdentifier("ÄÖÜäöüß".getBytes("ISO-8859-1"));
		Assert.assertTrue(identifier.determineISO_8859());
	}

	@Test
	public void testUTF8Ascii() throws Exception {
		CharsetIdentifier identifier = new CharsetIdentifier("ÄÖÜäöüß".getBytes("UTF-8"));
		Assert.assertFalse(identifier.determineISO_8859());
	}

	@Test
	public void testDefaultAscii() throws Exception {
		CharsetIdentifier identifier = new CharsetIdentifier("ÄÖÜäöüß".getBytes());
		Assert.assertFalse(identifier.determineISO_8859());
	}

}
