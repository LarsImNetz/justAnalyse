package org.linuxx.moonserver.utils;

import org.junit.Assert;
import org.junit.Test;

public class TestStringUtils {

	@Test
	public void testReverse() {
		Assert.assertEquals("", new StringUtils().reverse(""));
		Assert.assertEquals("a", new StringUtils().reverse("a"));
		Assert.assertEquals("ba", new StringUtils().reverse("ab"));
		Assert.assertEquals("cba", new StringUtils().reverse("abc"));
	}
}
