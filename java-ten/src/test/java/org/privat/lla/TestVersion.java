package org.privat.lla;

import org.junit.Assert;
import org.junit.Test;

public class TestVersion {

	@Test
	public void testAtLeastVersion() {
		var version = System.getProperty("java.version");
		Assert.assertTrue(10 <= Integer.parseInt(version));
	}
}
