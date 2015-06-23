package org.linuxx.moonserver.unittests;

import org.junit.Assert;
import org.junit.Test;

public class TestWithSame {

	@Test
	public void testSameValue() {
		String a = "ein a";
		String b = "ein a"; // Das ist ein Sonderfall in Java, da es der selbe String ist, macht der Compiler daraus ein Objekt

		Assert.assertSame(a, b);
	}

	@Test
	public void testNotSameValue() {
		String a = "ein a";
		String b = "ein b";

		Assert.assertNotSame(a, b);
	}
}
