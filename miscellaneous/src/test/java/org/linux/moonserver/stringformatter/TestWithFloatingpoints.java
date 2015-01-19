package org.linux.moonserver.stringformatter;

import org.junit.Assert;
import org.junit.Test;

public class TestWithFloatingpoints {

	@Test
	public void test() {
		double value = 1001.123d;
		Assert.assertEquals("1001", String.format("%.0f", value));
		Assert.assertEquals("1e+03", String.format("%.0g", value));
	}

}
