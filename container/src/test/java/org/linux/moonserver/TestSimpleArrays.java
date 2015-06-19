package org.linux.moonserver;

import org.apache.commons.lang3.StringUtils;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TestSimpleArrays {

	String[] strings;

	@Before
	public void setUp() {
		strings = new String[] { "a", "b", "c" };
	}

	@Test
	public void testLength() {
		Assert.assertEquals(3, strings.length);
	}

	@Test
	public void testAccess() throws Exception {
		String first = strings[0];
		Assert.assertEquals("a", first);
	}

	@Test
	public void testStringUtilsJoin() {
		String join = StringUtils.join(strings, ":");
		Assert.assertEquals("a:b:c", join);
	}

}
