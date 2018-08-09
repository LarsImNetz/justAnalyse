package org.linux.moonserver;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TestStringBuffer {

	StringBuffer buffer;

	@Before
	public void setUp() {
		buffer = new StringBuffer();
	}

	@Test
	public void testName() throws Exception {
		buffer.append("string");
		buffer.append('a');
		buffer.append("charArray".toCharArray());
		buffer.append(true);
		buffer.append(false);
		buffer.append(65536);
		buffer.append(1_000_000_000_000_000_001L);
		buffer.append(2.7f);
		buffer.append(3.1415d);
	
		Assert.assertEquals("stringacharArraytruefalse6553610000000000000000012.73.1415", buffer.toString());
	}

	@Test
	public void testCharAt() throws Exception {
		buffer.append("Super");
		Assert.assertEquals('u', buffer.charAt(1));
	}

	@Test
	public void testToString() {
		buffer.append("a");
		buffer.append("b");
		buffer.append("c");
		String all = buffer.toString();

		Assert.assertEquals("abc", all);
	}

	@Test
	public void testAppend() throws Exception {
		buffer.append("hallo");
		Assert.assertTrue(buffer.toString().contains("hallo"));
	}

	@Test
	public void testReverse() throws Exception {
		buffer.append("a");
		buffer.append("b");
		buffer.append("c");
		buffer.reverse();

		Assert.assertEquals("cba", buffer.toString());
	}
}
