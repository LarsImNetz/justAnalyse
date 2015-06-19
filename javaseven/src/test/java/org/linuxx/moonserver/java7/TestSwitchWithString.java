package org.linuxx.moonserver.java7;

import org.junit.Assert;
import org.junit.Test;

public class TestSwitchWithString {

	@Test
	public void test() {
		final String a = "hallo";

		switch (a) { // switch mit Strings
		case "hallo":
			break;
		default:
			Assert.fail("Sollte in java7 funktionieren.");
		}
	}

}
